package randp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import randp.entity.MediaEntity;
import randp.form.MediaForm;
import randp.service.MediaService;
import randp.util.FileUploader1;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by dyh on 2018/5/19.
 */
@Controller
@RequestMapping("/media")
public class MediaController {
    private static final int PAGE_SIZE = 10;
    @Resource
    private MediaService mediaService;

    @RequestMapping("/")
    public String index(ModelMap map){
        return pagem(1,map);
    }


    @RequestMapping(value = "/addvedio",method = RequestMethod.GET)
    public String publish(){
        return "/addvedio";
    }

    @RequestMapping(value = "/addvedio",method = RequestMethod.POST)
    public String add(@Valid MediaForm form,
                      @RequestParam(value = "mfile", required = false)MultipartFile mfile,
                      BindingResult result, HttpSession session){

        if (result.hasErrors()){
            for (Object err : result.getAllErrors())
                System.out.println(err.toString());
        }

        String murl = FileUploader1.upload(mfile,session);
        System.err.println("murl==" + murl);

        MediaEntity mediaEntity = new MediaEntity();
        mediaEntity.setCrname(form.getCrname());
        mediaEntity.setVname(form.getVname());
        mediaEntity.setMtype(form.getMtype());
        mediaEntity.setVideo(murl);
        mediaEntity.setMcomment(form.getMcomment());
        mediaService.save(mediaEntity);
        return "redirect:/media/";
    }

    @RequestMapping(path = "/page/{page}",method = RequestMethod.GET)
    public String pagem(@PathVariable(required = false) int page, ModelMap map){ //分页

        long count = mediaService.count();
        List list = mediaService.pagem(page-1,PAGE_SIZE);

        int maxPage = (int)Math.ceil((double) count/PAGE_SIZE);

        if (page < 1){
            return "redirect:/media/";
        }

        map.addAttribute("maxPage",maxPage);
        map.addAttribute("count",count);
        map.addAttribute("medialist",list);
        map.addAttribute("curPos",page);

        System.err.println("maxpage= " + maxPage);
        System.err.println("count= " + count);
        System.err.println("list = " + list.toString());

        int begin = page - 1 > 3 ? page - 3 : 1;
        int end = page + 3 > maxPage ? maxPage : page + 3;
        if (maxPage == 0)
            begin = end = 1;
        map.addAttribute("begin",begin);
        map.addAttribute("end",end);

        return "/vedio";
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String del(@PathVariable(required = false) long id){
        MediaEntity info = mediaService.getById(id);
        mediaService.delete(info);
        return "redirect:/media/";
    }

    @RequestMapping(value = "/play/{mid}",method = RequestMethod.GET)
    public String play(@PathVariable(required = false) long mid,ModelMap map){
        MediaEntity mediaEntity = mediaService.getById(mid);
        map.addAttribute("m", mediaEntity);
        System.err.println("url===" + mediaEntity.getVideo());
        return "/play";
    }

}

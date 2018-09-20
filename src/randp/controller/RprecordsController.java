package randp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import randp.entity.RprecordsEntity;
import randp.form.RprecordsForm;
import randp.service.RprecordsService;
import randp.util.FileUploader1;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
@Controller
@RequestMapping("/rprecords")
public class RprecordsController {

    private static final int PAGE_SIZE = 10;

    @Resource
    private RprecordsService rprecordsService;

    @RequestMapping("/")
    public String index(ModelMap map){
        return page1(1,map);
    }

    //添加文物保护修复历史记录
    @RequestMapping(value = "/addrecord",method = RequestMethod.GET)
    public String publish(){
        return "/addrecord";
    }


    @RequestMapping(value = "/addrecord",method = RequestMethod.POST)
    public String add(@Valid RprecordsForm form,
                      @RequestParam(value = "file1", required = false) MultipartFile file1,
                      @RequestParam(value = "file2", required = false) MultipartFile file2,
                      @RequestParam(value = "file3", required = false) MultipartFile file3,
                      BindingResult result, HttpSession session) throws IOException {

        if (result.hasErrors()){
            for (Object err : result.getAllErrors())
                System.out.println(err.toString());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date astime = new java.util.Date();
        try {
            astime = sdf.parse(form.getAstime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.err.println(file1);
        System.err.println(file2);
        System.err.println(file3);

        String bs = FileUploader1.upload(file1,session);
        String ds = FileUploader1.upload(file2,session);
        String as = FileUploader1.upload(file3,session);

//
        System.err.println(bs);
        System.err.println(ds);
        System.err.println(as);

        RprecordsEntity rprecordsEntity = new RprecordsEntity();
        rprecordsEntity.setBssize(form.getBssize());
        rprecordsEntity.setBsweight(Double.parseDouble(form.getBsweight()));
        rprecordsEntity.setBspicture(bs);
        rprecordsEntity.setBssave(form.getBssave());
        rprecordsEntity.setDisde(form.getDisde());
        rprecordsEntity.setDispic(ds);
        rprecordsEntity.setAssize(form.getAssize());
        rprecordsEntity.setAsweight(Double.parseDouble(form.getAsweight()));
        rprecordsEntity.setAspicture(as);
        rprecordsEntity.setAssave(form.getAssave());
        rprecordsEntity.setAstime(new Timestamp(astime.getTime()));
        rprecordsEntity.setCrname(form.getCrname());
        rprecordsService.save(rprecordsEntity);
        return "redirect:/rprecords/";
    }

    @RequestMapping(path = "/page/{page}",method = RequestMethod.GET)
    public String page1(@PathVariable(required = false) int page, ModelMap map){ //分页

        long count = rprecordsService.count();
        List list = rprecordsService.page1(page-1,PAGE_SIZE);

        int maxPage = (int)Math.ceil((double) count/PAGE_SIZE);

        if (page < 1){
            return "redirect:/rprecords/";
        }

        map.addAttribute("maxPage",maxPage);
        map.addAttribute("count",count);
        map.addAttribute("list1",list);
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

        return "/rprecords_list";
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable(required = false) long id,ModelMap map){
        map.addAttribute("news",rprecordsService.getById(id));
        return "/rprecords_detail";
    }
    @RequestMapping(value = "/detail/del",method = RequestMethod.POST)
    public String del(@Valid long id){
        RprecordsEntity info = rprecordsService.getById(id);
        rprecordsService.delete(info);
        return "redirect:/rprecords/";
    }

}


package randp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import randp.entity.ApplyEntity;
import randp.form.ApplyForm;
import randp.service.ApplyService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
@Controller
@RequestMapping("/applyc")
public class ApplyController {
    private static final int PAGE_SIZE = 10;
    @Resource
    private ApplyService applyService;

    @RequestMapping("/")
    public String index(ModelMap map){
        return applypage(1,map);
    }


    @RequestMapping(value = "/applyadd",method = RequestMethod.GET)
    public String publish(){
        return "/applyadd";
    }

    @RequestMapping(value = "/applyadd",method = RequestMethod.POST)
    public String add(@Valid ApplyForm form, BindingResult result){

        if (result.hasErrors()){
            for (Object err : result.getAllErrors())
                System.out.println(err.toString());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date extime = new java.util.Date();
        java.util.Date rttime = new java.util.Date();
        java.util.Date aptime = new java.util.Date();
        try {
            extime = sdf.parse(form.getExtime());
            rttime = sdf.parse(form.getRttime());
            aptime = sdf.parse(form.getAptime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ApplyEntity applyEntity = new ApplyEntity();
        applyEntity.setCrname(form.getCrname());
        applyEntity.setExname(form.getExname());
        applyEntity.setExtime(new Timestamp(extime.getTime()));
        applyEntity.setRtname(form.getRtname());
        applyEntity.setRttime(new Timestamp(rttime.getTime()));
        applyEntity.setRsname(form.getRsname());
        applyEntity.setApunit(form.getApunit());
        applyEntity.setAptime(new Timestamp(aptime.getTime()));
        applyEntity.setApnum(form.getApnum());
        applyService.save(applyEntity);
        return "redirect:/applyc/";
    }

    @RequestMapping(path = "/page/{page}",method = RequestMethod.GET)
    public String applypage(@PathVariable(required = false) int page, ModelMap map){ //分页

        long count = applyService.count();
        List list = applyService.applypage(page-1,PAGE_SIZE);

        int maxPage = (int)Math.ceil((double) count/PAGE_SIZE);

        if (page < 1){
            return "redirect:/applyc/";
        }

        map.addAttribute("maxPage",maxPage);
        map.addAttribute("count",count);
        map.addAttribute("applylist",list);
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

        return "/apply";
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String del(@PathVariable(required = false) long id){
        ApplyEntity info = applyService.getById(id);
        applyService.delete(info);
        return "redirect:/applyc/";
    }

}


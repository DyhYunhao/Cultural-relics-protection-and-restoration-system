package randp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import randp.entity.CulrelicEntity;
import randp.form.CulturalForm;
import randp.service.CulturalService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by dyh on 2018/5/12.
 */
@Controller
@RequestMapping("/cultural")
public class CulturalController {

    private static final int PAGE_SIZE = 10;

   @Resource
   private CulturalService culturalService;

    @RequestMapping("/")
    public String index(ModelMap map){
        return page(1,map);
    }

    //文物信息发布
    @RequestMapping(value = "/publish",method = RequestMethod.GET)
    public String publish(){
        return "/publish";
    }

    //申请经办
    @RequestMapping(value = "/apply",method = RequestMethod.GET)
    public String apply(){
        return "/apply";
    }

    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    public String add(@Valid CulturalForm form, BindingResult result){

        if (result.hasErrors()){
            for (Object err : result.getAllErrors())
                System.out.println(err.toString());
        }

        CulrelicEntity info = new CulrelicEntity();
        info.setCrname(form.getCrname());
        info.setCrcom(form.getCrcom());
        info.setCrcome(form.getCrcome());
        info.setCrhouse(form.getCrhouse());
        info.setCrlevel(form.getCrlevel());
        info.setCrmeq(form.getCrmeq());
        info.setCrnum(form.getCrnum());
        info.setCrtimes(form.getCrtimes());
        culturalService.save(info);

        return "redirect:/cultural/";
    }

    @RequestMapping(path = "/page/{page}",method = RequestMethod.GET)
    public String page(@PathVariable(required = false) int page, ModelMap map){ //分页

        long count = culturalService.count();
        List list = culturalService.page(page-1,PAGE_SIZE);

        int maxPage = (int)Math.ceil((double) count/PAGE_SIZE);

        if (page < 1){
            return "redirect:/cultural/";
        }

        map.addAttribute("maxPage",maxPage);
        map.addAttribute("count",count);
        map.addAttribute("list",list);
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

        return "/cultural_relic";
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable(required = false) long id,ModelMap map){
        map.addAttribute("news",culturalService.getById(id));
        return "/cultural_detail";
    }
    @RequestMapping(value = "/detail/del",method = RequestMethod.POST)
    public String del(@Valid long id){
        CulrelicEntity info = culturalService.getById(id);
        culturalService.delete(info);
        return "redirect:/cultural/";
    }

}

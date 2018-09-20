package randp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import randp.entity.RepairlogEntity;
import randp.form.RepairlogForm;
import randp.service.RepairlogService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by dyh on 2018/5/18.
 */
@Controller
@RequestMapping("/repairlog")
public class RepairlogController {

    @Resource
    private RepairlogService repairlogService;

    private long rid;


    @RequestMapping(value = "/detail/{rpid}",method = RequestMethod.GET)
    public String detail(@PathVariable(required = false) long rpid,ModelMap map){
        System.err.println("rpiddd==" + rpid);
        rid = rpid;
        map.addAttribute("repairloglist",repairlogService.getByFid(rpid));
        return "/repairlog_detail";
    }

    //添加文物保护修复历史记录
    @RequestMapping(value = "/addlog/{rpid}",method = RequestMethod.GET)
    public String publish(@PathVariable(required = false) long rpid){
        rid = rpid;
        return "/addlog";
    }


    @RequestMapping(value = "/addlog",method = RequestMethod.POST)
    public String add(@Valid RepairlogForm form,BindingResult result){

        if (result.hasErrors()){
            for (Object err : result.getAllErrors())
                System.out.println(err.toString());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date rltime = new java.util.Date();
        java.util.Date rlctime = new java.util.Date();
        try {
            rltime = sdf.parse(form.getRltime());
            rlctime = sdf.parse(form.getRlctime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.err.println("rpid==" + rid);


        RepairlogEntity repairlogEntity = new RepairlogEntity();
        repairlogEntity.setRlpep(form.getRlpep());
        repairlogEntity.setRpid(rid);
        repairlogEntity.setRltime(new Timestamp(rltime.getTime()));
        repairlogEntity.setRlpls(form.getRlpls());
        repairlogEntity.setRltool(form.getRltool());
        repairlogEntity.setRldecon(form.getRldecon());
        repairlogEntity.setRlchange(form.getRlchange());
        repairlogEntity.setRlctime(new Timestamp(rlctime.getTime()));
        repairlogEntity.setRlcname(form.getRlcname());
        repairlogService.save(repairlogEntity);
        return "redirect:/repairlog/detail/"+rid;
    }



    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String del(@PathVariable(required = false) long id){
        RepairlogEntity info = repairlogService.getById(id);
        repairlogService.delete(info);
        return "redirect:/repairlog/detail/"+rid;
    }
}

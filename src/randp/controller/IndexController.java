package randp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import randp.service.UserService;

import javax.annotation.Resource;

/**
 * Created by dyh on 2018/4/10.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "/index";
    }
}

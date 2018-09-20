package randp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import randp.entity.UsersEntity;
import randp.form.LoginForm;
import randp.form.RegisterForm;
import randp.form.UpdateForm;
import randp.service.UserService;
import randp.util.DatabaseBackup;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dyh on 2018/4/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String doLogin(@Validated LoginForm form, BindingResult result, HttpSession session){

        if (result.hasErrors() || !form.getVerifyCode().equalsIgnoreCase(String.valueOf(session.getAttribute("verifyCode")))){ //有错误信息
            return "";
        }

        UsersEntity user = userService.verify(form.getUsername(),form.getPassword());
        if (user != null) { //验证成功  将用户信息放入HttpSession
            session.setAttribute("user", user);
            UsersEntity use = (UsersEntity) session.getAttribute("user");
            use.setDcount(use.getDcount()+1);
            userService.update(use);
        }
        return "redirect:/";
    }

    //注册后自动登陆
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String doRegister(@Validated RegisterForm form, BindingResult result, HttpSession session){

        //验证不通过时待优化用户体验
        if (result.hasErrors() || !form.getConfirmPassword().equals(form.getPassword()) ||
                !form.getVerifyCode().equalsIgnoreCase(String.valueOf(session.getAttribute("verifyCode")))){
            return "redirect:/";
        }

        UsersEntity user = new UsersEntity();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
        user.setAddress(form.getAddress());
        user.setIdcard(form.getIdcard());
        user.setPost(form.getPost());
        user.setTypeid(form.getTypeid());
        user.setUnit(form.getUnit());
        userService.save(user); //持久化

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String doLogout(HttpSession session){
        if (session != null)
            session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/center",method = RequestMethod.GET)
    public String center(HttpSession session, ModelMap map, HttpServletRequest request, HttpServletResponse response){
        UsersEntity use = (UsersEntity) session.getAttribute("user");
        map.addAttribute("users", use);

        String IP = request.getRemoteAddr();
        String lastAccessTime=null;
        Cookie[] cookies=request.getCookies();
        for(int i=0;cookies!=null && i<cookies.length;i++)
        {
            if("lastAccessTime".equals(cookies[i].getName()))
            {
                lastAccessTime=cookies[i].getValue();
                break;
            }
        }
        if(lastAccessTime==null)
        {
            lastAccessTime = "first time";
        }
        String currenttime=new SimpleDateFormat("yyyy/MM/dd--hh:mm:ss").format(new Date());
        Cookie cookie=new Cookie("lastAccessTime",currenttime);
        response.addCookie(cookie);

        System.err.println(IP);
        System.err.println(lastAccessTime);
        use.setLip(IP);
        use.setLtime(new Timestamp(new Date().getTime()));
        userService.update(use);
        map.addAttribute("ip", IP);
        map.addAttribute("ltime", lastAccessTime);

        return "/user_detail";
    }

    @RequestMapping("/update")
    public String update(HttpSession session,ModelMap map){
        UsersEntity use = (UsersEntity) session.getAttribute("user");
        map.addAttribute("usersp", use);
        return "/user_update";
    }
    @RequestMapping("/affupdate")
    public String affupdate(@Validated UpdateForm form, HttpSession session){
        UsersEntity use = (UsersEntity) session.getAttribute("user");
        use.setEmail(form.getEmail());
        use.setPhone(form.getPhone());
        use.setAddress(form.getAddress());
        use.setIdcard(form.getIdcard());
        use.setPost(form.getPost());
        use.setTypeid(form.getTypeid());
        use.setUnit(form.getUnit());
        userService.update(use);
        return "redirect:/";
    }


    @RequestMapping("/backup")
    public String backup(){
        DatabaseBackup databaseBackup = new DatabaseBackup();
        databaseBackup.backup();
        return "redirect:/";
    }

    @RequestMapping("/restore")
    public String restore(){
        DatabaseBackup databaseBackup = new DatabaseBackup();
        databaseBackup.restore();
        return "redirect:/";
    }

}


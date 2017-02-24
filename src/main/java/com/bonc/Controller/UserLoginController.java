package com.bonc.Controller;

import com.bonc.Entity.User;
import com.bonc.Service.UserValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by ZK on 2017/2/23.
 */
@Controller
@RequestMapping("/loveAmoy")
@SessionAttributes("user")
public class UserLoginController {

    @Autowired
    private UserValidateService userValidateService;

    @RequestMapping("/login")
    public String index(){
        return "login";
    }

    @RequestMapping("/signin")
    public ModelAndView login(@RequestParam("userName")String userName,@RequestParam("password")String inputPassword){
        ModelAndView mv = new ModelAndView();
        User user = userValidateService.validatePassword(userName,inputPassword);
        if (null == user){
            mv.addObject("message","Sorry,wrong username or password,please login again!");
            mv.setViewName("login");
        }else {
            mv.addObject("user",user);
            mv.setViewName("main");
        }
        return mv;
    }
}

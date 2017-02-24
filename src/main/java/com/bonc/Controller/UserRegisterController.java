package com.bonc.Controller;

import com.bonc.Entity.User;
import com.bonc.Service.UserRegisterService;
import com.bonc.Service.UserValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ZK on 2017/2/23.
 */
@RestController
@RequestMapping("/loveAmoy")
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserValidateService userValidateService;

    private Map<String,Integer> map = new HashMap<String, Integer>();
    {
        map.put("userName",1);
        map.put("realId",2);
        map.put("phoneNum",3);
        map.put("mailAddr",4);
    }

    @RequestMapping("/register")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("/signup")
    public ModelAndView register(@ModelAttribute User user){
        ModelAndView mv = new ModelAndView();
        userRegisterService.register(user);
        mv.addObject("user", user);
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/validate")
    public ModelAndView validate(@RequestParam("label") String label,@RequestParam("input") String input){
        ModelAndView mv = new ModelAndView();
        boolean flag;
        switch (map.get(label)){
            case 1:
                flag = userValidateService.validateUserName(input);
                break;
            case 2:
                flag = userValidateService.validateRealId(input);
                break;
            case 3:
                flag = userValidateService.validatePhoneNum(input);
                break;
            case 4:
                flag = userValidateService.validateMail(input);
                break;
            default:
                flag = false;
        }
        mv.addObject("flag",flag);
        mv.setViewName("register");
        System.out.println(flag);
        return mv;
    }
}

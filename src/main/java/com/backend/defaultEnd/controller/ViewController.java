package com.backend.defaultEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.model.*;
import com.backend.defaultEnd.service.*;

/**
 * Created by kevin on 2017/4/29.
 */
@Controller
public class ViewController {

    private LoginService loginService;
    private RegisterService registerService;
    public String passwordTemp;


    @Autowired(required = true)
    @Qualifier(value = "loginService")
    public void setLoginService(LoginService us) {
        this.loginService = us;
    }

    @Autowired(required = true)
    @Qualifier(value = "registerService")
    public void setRegisterService(RegisterService us) {
        this.registerService = us;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String toRegister(Model model){
        model.addAttribute("user",new UserEntity());
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("user")UserEntity userEntity){
        if(this.registerService.registerUser(userEntity)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toLogin(Model model){
        model.addAttribute("user",new UserEntity());
        return  "index";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String login(@ModelAttribute("user")UserEntity user,@ModelAttribute("style")int style){

        if((passwordTemp=this.loginService.findUser(user.getUserName()).getPassword())!=null) {
            passwordTemp=passwordTemp.trim();
            if (passwordTemp.equals(user.getPassword())) {
                switch (style) {
                    case 1:
                        return "redirect:/buyer/"+user.getUserName();
                    case 2:
                        return "redirect:/seller/"+user.getUserName();
                    case 3:
                        return "redirect:/admin/"+user.getUserName();
                }
            } else
                return "error";
        }else
            return "error";
        return "error";
    }


}

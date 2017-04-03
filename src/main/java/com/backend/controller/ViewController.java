package com.backend.controller;

/**
 * Created by kevin on 2017/3/29.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
    @RequestMapping("/")
    public String view(){
        return "index";
    }

    @RequestMapping("/Login")
    public String login(){
        return "login";
    }

    @RequestMapping("/UserControl")
    public String userControl(){
        return  "user";
    }

    @RequestMapping("ItemsControl")
    public String itemsControl(){
        return "items";
    }

}

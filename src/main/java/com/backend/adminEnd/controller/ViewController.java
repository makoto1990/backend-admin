package com.backend.adminEnd.controller;

/**
 * Created by kevin on 2017/3/29.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
    @RequestMapping("/")
    public String adminIndex(){
        return "index";
    }

    @RequestMapping("/UserControl")
    public String adminUserControl(){
        return "user";
    }

    @RequestMapping("/GoodsControl")
    public String adminGoodsControl(){
        return "goods";
    }

    @RequestMapping("/OrderControl")
    public String adminOrderControl(){
        return "order";
    }

    @RequestMapping("/SellerControl")
    public String adminSellerControl(){
        return "seller";
    }

    @RequestMapping("/Composition")
    public String adminCompositionControl(){
        return "composition";
    }

}

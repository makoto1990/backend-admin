package com.backend.controller;

/**
 * Created by kevin on 2017/3/29.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
    @RequestMapping("/")
    public String loginIndex(){
        return "login/index";
    }

    @RequestMapping("/admin/")
    public String adminIndex(){
        return "admin/index";
    }

    @RequestMapping("/admin/UserControl")
    public String adminUserControl(){
        return "admin/user";
    }

    @RequestMapping("/admin/GoodsControl")
    public String adminGoodsControl(){
        return "admin/goods";
    }

    @RequestMapping("/admin/OrderControl")
    public String adminOrderControl(){
        return "admin/order";
    }

    @RequestMapping("/admin/SellerControl")
    public String adminSellerControl(){
        return "admin/seller";
    }

    @RequestMapping("/admin/Composition")
    public String adminCompositionControl(){
        return "admin/composition";
    }

}

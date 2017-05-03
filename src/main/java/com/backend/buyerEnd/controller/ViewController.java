package com.backend.buyerEnd.controller;

/**
 * Created by kevin on 2017/5/3.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.buyerEnd.service.*;
import com.backend.model.*;
import java.util.*;
@Controller
public class ViewController {
    private DetailService detailService;
    private GoodsService goodsService;
    private UserService userService;
    private SearchService searchService;
    @Autowired(required = true)
    @Qualifier(value = "detailService")
    public void setDetailService(DetailService ds){this.detailService=ds;}

    @Autowired(required = true)
    @Qualifier(value = "buyerGoodsService")
    public void setGoodsService(GoodsService gs){this.goodsService=gs;}

    @Autowired(required = true)
    @Qualifier(value = "buyerUserService")
    public void setUserService(UserService us){this.userService=us;}

    @Autowired(required = true)
    @Qualifier(value = "searchService")
    public void setSearchService(SearchService ss){this.searchService=ss;}

    @RequestMapping("/")
    public String buyerIndex(){
        return "buyMain";
    }

    @RequestMapping("/Cart")
    public String buyerCart(){
        return "buyCart";
    }

    @RequestMapping("/UserInfo")
    public String userInfo(){
        return "buyerUserInfor";
    }

    @RequestMapping("/DeliveryInfo")
    public String deliveryInfo(){
        return "buyUser";
    }

    @RequestMapping(value = "/Search",method = RequestMethod.POST)
    public String searchGoods(Model model,@ModelAttribute("searchinfo")String searchInfo){
        model.addAttribute("allgoods",this.searchService.loadAllGoods(searchInfo));
        return "buySearch";
    }


}

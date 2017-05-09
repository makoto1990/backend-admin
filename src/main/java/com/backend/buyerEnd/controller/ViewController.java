package com.backend.buyerEnd.controller;

/**
 * Created by kevin on 2017/5/3.
 */
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
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
    public String buyerIndex(HttpServletRequest request,Model model){
        if(request.getSession().getAttribute("sname")==null){
            return "saleError";
        }
        ArrayList<String> allType;
        allType=this.searchService.getAllType();
        request.getSession().setAttribute("goodsTypes",allType);
        ArrayList<GoodsEntity> allGoods;
        allGoods=this.searchService.loadAllGoods();
        request.getSession().setAttribute("username",request.getSession().getAttribute("sname"));
        request.getSession().setAttribute("allGoods",allGoods);
        return "buyMain";
    }

    @RequestMapping("/Cart")
    public String buyerCart(){
        return "buyCart";
    }

    @RequestMapping("/BuyDetail/{id}")
    public String buyDetail(@PathVariable("id")String id,HttpServletRequest request){
        request.getSession().setAttribute("flag",id);
        return "buyDetail";
    }

    @RequestMapping("/UserInfo")
    public String userInfo(HttpServletRequest request){
        String name = request.getSession().getAttribute("sname").toString();
        UserEntity userEntity = this.userService.getUserByUserName(name);
        request.getSession().setAttribute("userEntity",userEntity);
        return "buyerUserInfor";
    }

    @RequestMapping("/DeliveryInfo")
    public String deliveryInfo(){
        return "buyUser";
    }

    @RequestMapping(value = "/Search",method = RequestMethod.POST)
    public String searchGoods(@ModelAttribute("searchinfo")String searchInfo,HttpServletRequest request){
        request.getSession().setAttribute("allgoods",this.searchService.loadAllGoods(searchInfo));
        return "buySearch";
    }


}

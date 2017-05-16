package com.backend.buyerEnd.controller;

/**
 * Created by kevin on 2017/5/3.
 */
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private OrderService orderService;
    private CartService cartService;

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
    public void setSearchService(SearchService ss){ this.searchService=ss; }

    @Autowired(required = true)
    @Qualifier(value = "buyerOrderService")
    public void setOrderService(OrderService os){
        this.orderService=os;
    }

    @Autowired(required = true)
    @Qualifier(value = "buyerCartService")
    public void setCartService(CartService cs){
        this.cartService=cs;
    }

    @RequestMapping("/")
    public String buyerIndex(HttpServletRequest request){
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
        this.cartService.initCart((String)request.getSession().getAttribute("sid"));
        request.getSession().setAttribute("cartSevice",this.cartService);
        return "buyMain";
    }

    @RequestMapping("/Cart")
    public String buyerCart(HttpServletRequest request){
        request.getSession().setAttribute("cartService",this.cartService);
        request.getSession().setAttribute("svc",this.detailService);
        return "buyCart";
    }

    @RequestMapping("/BuyDetail/AddItem")
    public String addItem(@ModelAttribute("out")int number, HttpServletRequest request){
        String goodsId=(String) request.getSession().getAttribute("goodsId");
        this.cartService.addGoods(goodsId,number);
        request.getSession().setAttribute("cartService",this.cartService);
        return "buyDetail";
    }

    @RequestMapping("/BuyDetail/{id}")
    public String buyDetail(@PathVariable("id")String id,HttpServletRequest request){
        request.getSession().setAttribute("flag",id);
        request.getSession().setAttribute("svc",this.detailService);
        return "buyDetail";
    }

    @RequestMapping("/User/Info")
    public String userInfo(HttpServletRequest request){
        String name = request.getSession().getAttribute("sname").toString();
        UserEntity userEntity = this.userService.getUserByUserName(name);
        request.getSession().setAttribute("userEntity",userEntity);
        return "buyerUserInfor";
    }

    @RequestMapping("/DeliveryInfo")
    public String deliveryInfo(HttpServletRequest request){
        request.getSession().setAttribute("orderService",this.orderService);
        request.getSession().setAttribute("userService",this.userService);
        return "buyUser";
    }

    @RequestMapping(value = "/Search",method = RequestMethod.POST)
    public String searchGoods(@ModelAttribute("searchinfo")String searchInfo,HttpServletRequest request){
        request.getSession().setAttribute("allgoods",this.searchService.loadAllGoods(searchInfo));
        return "buySearch";
    }

    @RequestMapping(value = "/User/Update",method = RequestMethod.POST)
    public String updateUser(@PathVariable("username")String username1,HttpServletRequest request){
        boolean relogin = false;
        boolean resure = false;
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        String username = request.getParameter("username");//用户昵称
        String password = request.getParameter("password");//密码
        String password2 = request.getParameter("password2");//确认密码
        String realname = request.getParameter("realname");//真实姓名
        String idnumber = request.getParameter("idnumber");//身份证号
        String phone = request.getParameter("phone");//联系电话
        String postcode = request.getParameter("postcode");//邮编
        String province = request.getParameter("province");//省
        String city = request.getParameter("city");//市
        String district = request.getParameter("district");//区/县
        String street = request.getParameter("street");//街道
        String address = request.getParameter("address");//地址
        if(!username.equals("")){ user.setUserName(username); relogin=true; }//修改昵称，需重新登录
        if(!password.equals(password2)){
            //System.out.println("两次输入不一致");
            resure = true;
        }
        else if(!password.equals("")){ user.setPassword(password); relogin=true; }//修改密码，需重新登录
        if(!realname.equals(""))user.setRealName(realname);
        if(!idnumber.equals(""))user.setiDnumber(idnumber);
        if(!phone.equals(""))user.setPhone(phone);
        if(!postcode.equals(""))user.setPostcode(postcode);
        if(!province.equals(""))user.setProvince(province);
        if(!city.equals(""))user.setCity(city);
        if(!district.equals(""))user.setDistrict(district);
        if(!street.equals(""))user.setStreet(street);
        if(!address.equals(""))user.setAddress(address);
        this.userService.updateUser(user);
        request.getSession().setAttribute("sname", user.getUserName());
        if(resure)return "userInforAlter";
        else if(!relogin)return "redirect:/buyer/User/Info";
        else return "redirect:/buyer/";
    }


}

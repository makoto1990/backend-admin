package com.backend.sellerEnd.controller;

import com.backend.sellerEnd.service.*;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by kevin on 2017/5/8.
 */
@Controller
public class ViewController {

    private SellerService sellerService;
    private SearchService searchService;
    private PictureUploadService pictureUploadService;
    private GoodsService goodsService;
    private OrderService orderService;

    @Autowired(required = true)
    @Qualifier("orderSearchService")
    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @Autowired(required = true)
    @Qualifier("editSellerService")
    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Autowired(required = true)
    @Qualifier("pictureUploadService")
    public void setPictureUploadService(PictureUploadService pictureUploadService) {
        this.pictureUploadService = pictureUploadService;
    }

    @Autowired(required = true)
    @Qualifier("sellerGoodsService")
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Autowired(required = true)
    @Qualifier("sellerOrderService")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping("/")
    public String sellerMain(HttpServletRequest request){
        if (request.getSession().getAttribute("sname")==null){
            return "redirect:/";
        }
        request.getSession().setAttribute("sellerService",this.sellerService);
        request.getSession().setAttribute("goodsService",this.goodsService);
        request.getSession().setAttribute("searchService",this.searchService);
        return "saleMain";
    }

    @RequestMapping("/Seller/Edit")
    public String editSeller(@ModelAttribute("userName") String userName, @ModelAttribute("Phone") String phone, @ModelAttribute("postCode") String postCode, @ModelAttribute("Province") String province, @ModelAttribute("City") String city, @ModelAttribute("District") String district, @ModelAttribute("Street") String street, @ModelAttribute("Address") String address, @ModelAttribute("sellerIntro") String sellerIntro) {
        System.out.println("接收到编辑卖家信息请求");
        String[] name = {"userName", "Phone", "PostCode", "Province", "City", "District", "Street", "Address", "sellerIntro"};
        String[] info = new String[9];
        info[0] = userName;
        info[1] = phone;
        info[2] = postCode;
        info[3] = province;
        info[4] = city;
        info[5] = district;
        info[6] = street;
        info[7] = address;
        info[8] = sellerIntro;
        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i]);
        }
        this.sellerService.saveEdit(name, info);
        return "redirect:/seller";
    }

    @RequestMapping("/Search/Order")
    public String searchOrder(@ModelAttribute("select") String searchType, @ModelAttribute("input") String searchValue, HttpServletRequest request) {
        request.getSession().setAttribute("list", this.searchService.searchOrder(searchType, searchValue));
        return "saleOrderSearch";
    }

    @RequestMapping(value = "/Goods/SaleRelease",method = RequestMethod.POST)
    public String getSaleRelease(@ModelAttribute("sellerName") String sellerName, HttpServletRequest request) {
        request.getSession().setAttribute("goodsList", this.goodsService.getRelease(sellerName));
        return "saleReleaseOfGoods";
    }

    @RequestMapping(value = "/Goods/SaleRelease/Search/{sellerName}",method = RequestMethod.POST)
    public String searchGoods(@ModelAttribute("goodsType") String goodsType, @PathVariable("sellerName") String sellerName, HttpServletRequest request) {
        request.getSession().setAttribute("goodsList", this.goodsService.searchGoods(goodsType, sellerName));
        return "saleReleaseOfGoods";
    }

    @RequestMapping("/Goods/Edit/{goodsID}")
    public String editGoods(@PathVariable("goodsID") String goodsID, HttpServletRequest request) {
        request.getSession().setAttribute("goods", this.goodsService.editGoods(goodsID));
        return "saleEditGoods";
    }

    @RequestMapping("/Goods/SaveEdit")
    public String saveGoodsEdit(@ModelAttribute("goodsID") String goodsID, @ModelAttribute("name") String name, @ModelAttribute("count") String count, @ModelAttribute("price") String price, @ModelAttribute("storeWay") String storeWay, @ModelAttribute("sourceArea") String sourceArea, @ModelAttribute("type") String type, @ModelAttribute("leastAmount") String leastAmount, @ModelAttribute("largeAmount") String largeAmount, @ModelAttribute("largePrice") String largePrice, @ModelAttribute("goodsSize") String goodsSize, @ModelAttribute("goodsIntro") String goodsIntro, HttpServletRequest request) {
        String[] values = new String[12];
        values[0] = goodsID;
        values[1] = name;
        values[2] = count;
        values[3] = price;
        values[4] = storeWay;
        values[5] = sourceArea;
        values[6] = type;
        values[7] = leastAmount;
        values[8] = largeAmount;
        values[9] = largePrice;
        values[10] = goodsSize;
        values[11] = goodsIntro;
        request.getSession().setAttribute("goods", this.goodsService.saveEdit(values));
        return "saleEditGoods";
    }

    @RequestMapping("/Goods/Delete/{goodsID}")
    public String deleteGoods(@ModelAttribute("sellerName") String sellerName, @PathVariable("goodsID") String goodsID, HttpServletRequest request) {
        request.getSession().setAttribute("goodsList", this.goodsService.deleteGoods(goodsID, sellerName));
        return "saleReleaseOfGoods";
    }

    @RequestMapping("/Goods/Add")
    public String addGoods(@ModelAttribute("sellerName") String sellerName, @ModelAttribute("addGoodsID") String goodsID, @ModelAttribute("addGoodsName") String name, @ModelAttribute("addGoodsCount") String count, @ModelAttribute("addGoodsPrice") String price, @ModelAttribute("addStoreWay") String storeWay, @ModelAttribute("addSourceArea") String sourceArea, @ModelAttribute("addGoodsType") String type, @ModelAttribute("addLeastAmount") String leastAmount, @ModelAttribute("addLargeAmount") String largeAmount, @ModelAttribute("addLargePrice") String largePrice, @ModelAttribute("addGoodsSize") String goodsSize, @ModelAttribute("addGoodsIntro") String goodsIntro, HttpServletRequest request) {
        String[] values = new String[14];
        values[0] = goodsID;
        values[1] = name;
        values[2] = count;
        values[3] = price;
        values[4] = storeWay;
        values[5] = sourceArea;
        Date dt = new Date();
        values[6] = String.valueOf(dt);
        values[7] = this.goodsService.sellerID(sellerName);
        values[8] = type;
        values[9] = leastAmount;
        values[10] = largeAmount;
        values[11] = largePrice;
        values[12] = goodsSize;
        values[13] = goodsIntro;
        request.getSession().setAttribute("addGoodsID", this.goodsService.addGoods(values));
        return "saleAddGoodsPic";
    }

    @RequestMapping("/Goods/UploadImage")
    public String uploadPicture(@ModelAttribute("goodsID") String goodsID, @RequestParam(value = "uploadFile", required = false) MultipartFile file, HttpServletRequest request, Model model) {
        this.pictureUploadService.uploadPicture(goodsID, file, request);
        return "redirect:/seller/Goods/Edit/" + goodsID;
    }

    @RequestMapping("/Order/Update")
    public String updateOrderStatus(@ModelAttribute("contro") String contro, @ModelAttribute("id") String id) {
        this.orderService.updateOrderStatus(contro, id);
        return "redirect:/seller/Order/Details/" + id;
    }

    @RequestMapping("/Order/Detail/{id}")
    public String orderDetail(@PathVariable("id")String id,HttpServletRequest request){
        request.getSession().setAttribute("id",id);
        request.getSession().setAttribute("searchService",this.searchService);
        return "saleOrderDetails";
    }
}

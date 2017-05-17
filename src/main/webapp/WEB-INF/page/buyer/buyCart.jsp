<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
         import="com.backend.model.*" %>
<%@ page import="com.backend.buyerEnd.service.DetailService" %>
<%@ page import="com.backend.buyerEnd.service.CartService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户页面</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/resources/jquery/jquery.min.js"></script>
    <script src="/resources/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<%
    String name = request.getSession().getAttribute("sname").toString();
%>

<%@ include file="header.jsp" %>

<table class="table table-striped">
    <caption>购物车信息</caption>
    <thead>
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>订单数量</th>
        <th>合计价格</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%
            DetailService svc = (DetailService)request.getSession().getAttribute("svc");
            CartService cart = (CartService) request.getSession().getAttribute("cartService");
            if(cart.getCart()==null){
                cart.setCart(new HashMap<String,Integer>());
            }
            for (String goodsId : cart.getCart().keySet()) {
                GoodsEntity goods=svc.getGoodsByGoodsId(goodsId);
        %>
        <td><%=goods.getGoodsName() %>
        </td>
        <td><%=goods.getGoodsPrice() %>
        </td>
        <td><%=cart.getCart().get(goodsId) %>
        </td>
        <td><%=cart.getCost(goods) %>
        </td>
        <td>删除</td>
        <%
            }
        %>
    </tr>
    </tbody>
</table>


</body>
</html>
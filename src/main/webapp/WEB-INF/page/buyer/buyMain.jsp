<%@ page language="java" contentType="text/html; charset=utf-8" import="com.backend.model.*" import="com.backend.model.GoodsEntity"
         import="javax.servlet.http.HttpSession" pageEncoding="utf-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.backend.buyerEnd.service.CartService" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>支农网上生鲜超市</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/resources/jquery/jquery.min.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String name = request.getSession().getAttribute("sname").toString();//name即为由login传值的登录名
    CartService cart = (CartService) request.getSession().getAttribute("cartService");
%>

<div class="container">

    <%@ include file="header.jsp" %>


    <!-- 轮播框 -->
    <center>
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="/resources/images/top1.png" alt="First slide">
                    <!-- <img src="/wp-content/uploads/2014/07/slide1.png" alt="First slide">  -->
                </div>
                <div class="item">
                    <img src="/resources/images/top2.png" alt="Second slide">
                    <!--<img src="/wp-content/uploads/2014/07/slide2.png" alt="Second slide">  -->
                </div>
                <div class="item">
                    <img src="/resources/images/top3.png" alt="Third slide">
                    <!--<img src="/wp-content/uploads/2014/07/slide3.png" alt="Third slide">  -->
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;</a>
        </div>
    </center>

    <br/>

    <!-- 商品展示 -->

    <div class="row">
        <%
            String str = "/resources/images/";
            ArrayList<GoodsEntity> allGoods = (ArrayList) request.getSession().getAttribute("allGoods");
            HttpSession sess = request.getSession();
            i = 0;
            for (GoodsEntity tmp : allGoods) {
                String goodsName = tmp.getGoodsName().trim();
                String picPath = str + tmp.getPicture();
                String detailPath = "/buyer/BuyDetail/" + i;
                sess.setAttribute("goodsName" + i, tmp.getGoodsName());
                sess.setAttribute("goodsId" + i, tmp.getGoodsId());
                sess.setAttribute("goodsType" + i, tmp.getGoodsType());
                sess.setAttribute("sellerId" + i, tmp.getSellerId());
                i++;
        %>
        <div class="col-sm-6 col-md-3">
            <div class="thumbnail">
                <div class="caption">
                    <a href=<%=detailPath %>>
                        <center><img src=<%=picPath %> height="80px" width="120px"/></center>
                        <h3>商品名称:<%=goodsName%>
                        </h3>
                        <h4>价格：¥<%=tmp.getGoodsPrice() %>元</h4>
                        <h5>产地：<%=tmp.getSourceArea() %>
                        </h5>
                        <h6>类别：<%=tmp.getGoodsType() %>
                        </h6>

                    </a>
                </div>
            </div>
        </div>
        <% } %>
    </div>

    <!--     第三部分 -->
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
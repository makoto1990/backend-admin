<%@ page language="java" contentType="text/html; charset=utf-8" import="com.backend.model.Cart" import="com.backend.model.GoodsEntity"
         import="javax.servlet.http.HttpSession" pageEncoding="utf-8" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    Cart cart = (Cart) request.getSession().getAttribute("scart");
    if (cart == null) cart = new Cart();
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
                String picPath = str + goodsName + ".jpg";
                String detailPath = "/buy/BuyDetail/" + i;
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
    <div id="content">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="row clearfix">
                    <div class="col-md-8 column" style="background: blue">
                        <p>显示更新产品介绍，包括类别，定价等，以及进行购买</p>
                    </div>
                    <div class="col-md-4 column" style="background: blue">
                        <p>最新优秀宣传的产品等</p>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--     第四部分 -->
    <div id="footer">
        <div class="row clearfix">
            <div class="col-md-12 column" style="background: red">
                <p>介绍一下网站基本信息，友情链接等</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
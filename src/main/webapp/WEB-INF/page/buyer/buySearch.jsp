<%@ page language="java" contentType="text/html; charset=utf-8" import="com.backend.model.GoodsEntity"
         import="java.util.List" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>支农网上生鲜超市</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String name = request.getSession().getAttribute("sname").toString();//name即为由login传值的登录名 
%>
<div class="container">

    <%@ include file="header.jsp" %>

    <!-- 商品展示 -->

    <div class="row">
        <% List<GoodsEntity> allGoods = new ArrayList<>();
            allGoods.clear();
            allGoods = (List) request.getSession().getAttribute("searchGoods");
            int l = allGoods.size();
            HttpSession sess = request.getSession();
            sess.setAttribute("userName", name);
            String str = "/resources/images/";
            for (i = 0; i < l; i++) {
                GoodsEntity tmp = allGoods.get(i);
                String goodsName = tmp.getGoodsName().trim();
                String picPath = str + goodsName + ".jpg";
                String detailPath = "/buyer/BuyDetail/" + i;
                sess.setAttribute("goodsName" + i, tmp.getGoodsName());
                sess.setAttribute("goodsId" + i, tmp.getGoodsId());
                sess.setAttribute("goodsType" + i, tmp.getGoodsType());
                sess.setAttribute("sellerId" + i, tmp.getSellerId());
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
                        <h6>商家：<%=tmp.getSellerId() %>
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
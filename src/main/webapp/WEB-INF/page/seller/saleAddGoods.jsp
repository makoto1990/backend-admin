<%@ page language="java" contentType="text/html; charset=utf-8" import="com.backend.model.*"
         import="com.backend.sellerEnd.*"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>支农网上生鲜超市</title>
    <script type="text/javascript" src="/resources/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <link href="/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

</head>

<body>
<nav class="navbar navbar-default" style="padding:20px">
    <a href="/" class=navbar-brand" style="padding:40px"><span class="glyphicon glyphicon-home">首页</a>
    <form action="/seller/GoodsControServlet?value=release" method="post">
        <input type="submit" class="btn btn-default" value="返回">
    </form>
</nav>

<div class="container" style="background-color:#CCCCCC">
    <%!
        GoodsEntity goods = new GoodsEntity();
        String goodsname;
    %>
    <%
        goods = (GoodsEntity) request.getSession().getAttribute("goods");
    %>
    <form action="/seller/Goods/SaveEdit?goodsID=<%=goods.getGoodsId() %>"
          method="post">

        <table border="4">
            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">商品编号:</td>
                <td class="col-sm-3 col-md-2"><input type="text" disabled placeholder="<%=goods.getGoodsId() %>"></td>

                <td style="padding:20px" class="col-sm-3 col-md-2">商品名称：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="name" placeholder="<%=goods.getGoodsName()%>">
                </td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">商品数量：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="count" placeholder="<%=goods.getGoodsCount()%>">
                </td>

                <td style="padding:20px" class="col-sm-3 col-md-2">商品单价:</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="price" placeholder="<%=goods.getGoodsPrice() %>">
                </td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">运输中存储：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="storeWay" placeholder="<%=goods.getStoreWay()%>">
                </td>

                <td style="padding:20px" class="col-sm-3 col-md-2">原产地：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="sourceArea"
                                                     placeholder="<%=goods.getSourceArea()%>"></td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">商品类别:</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="type" placeholder="<%=goods.getGoodsType() %>">
                </td>

                <td style="padding:20px" class="col-sm-3 col-md-2">起送量：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="leastAmount"
                                                     placeholder="<%=goods.getLeastAmount()%>"></td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">大量采购起送量：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="largeAmount"
                                                     placeholder="<%=goods.getLargeAmount()%>"></td>

                <td style="padding:20px" class="col-sm-3 col-md-2">大量采购价：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="largePrice"
                                                     placeholder="<%=goods.getLargePrice()%>"></td>
            </tr>
        </table>

        <div>
            <h4>商品图片：</h4>
            <div class="thumbnail" style="height:220px;width:300px">
                <div style="height:220px;width:220px" overflow:hidden; text-align:center; border:1px solid red;>
                    <img src="<%=goods.getPicture() %>"
                         class="img-responsive center-block" alt="通用的占位符缩略图"
                         style="display:inline-block; vertical-align:middle; max-height:220px; max-width:250px;">
                </div>
            </div>
            <button class="btn btn-default btn-lg">选择图片</button>
        </div>
        <div style="padding-top:20px">
            <button type="submit" class="btn btn-primary btn-lg">保存修改</button>

            &nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn btn-default btn-lg">取消修改</button>
    </form>
</div>
</div>
</body>
</html>
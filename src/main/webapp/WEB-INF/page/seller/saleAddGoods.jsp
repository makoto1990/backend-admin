<%@ page language="java" contentType="text/html; charset=utf-8" import="com.demo.supermarket.*"
         import="com.demo.supermarketSale.*"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>支农网上生鲜超市</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
    <link href="../bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

</head>

<body>
<nav class="navbar navbar-default" style="padding:20px">
    <a href="../index.jsp" class=navbar-brand" style="padding:40px"><span class="glyphicon glyphicon-home">首页</a>
    <form action="${pageContext.request.contextPath}/GoodsControServlet?value=release" method="post">
        <input type="submit" class="btn btn-default" value="返回">
    </form>
</nav>

<div class="container" style="background-color:#CCCCCC">
    <%!
        Goods goods = new Goods();
        String goodsname;
    %>
    <%
        goods = (Goods) request.getSession().getAttribute("goods");
    %>
    <form action="${pageContext.request.contextPath}/GoodsControServlet?value=saveedit&goodsID=<%=goods.getgoodsID() %>"
          method="post">

        <table border="4">
            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">商品编号:</td>
                <td class="col-sm-3 col-md-2"><input type="text" disabled placeholder="<%=goods.getgoodsID() %>"></td>

                <td style="padding:20px" class="col-sm-3 col-md-2">商品名称：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="name" placeholder="<%=goods.getgoodsName()%>">
                </td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">商品数量：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="count" placeholder="<%=goods.getgoodsCount()%>">
                </td>

                <td style="padding:20px" class="col-sm-3 col-md-2">商品单价:</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="price" placeholder="<%=goods.getgoodsPrice() %>">
                </td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">运输中存储：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="storeWay" placeholder="<%=goods.getstoreWay()%>">
                </td>

                <td style="padding:20px" class="col-sm-3 col-md-2">原产地：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="sourceArea"
                                                     placeholder="<%=goods.getsourceArea()%>"></td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">商品类别:</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="type" placeholder="<%=goods.getgoodsType() %>">
                </td>

                <td style="padding:20px" class="col-sm-3 col-md-2">起送量：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="leastAmount"
                                                     placeholder="<%=goods.getleastAmount()%>"></td>
            </tr>

            <tr>
                <td style="padding:20px" class="col-sm-3 col-md-2">大量采购起送量：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="largeAmount"
                                                     placeholder="<%=goods.getlargeAmount()%>"></td>

                <td style="padding:20px" class="col-sm-3 col-md-2">大量采购价：</td>
                <td class="col-sm-3 col-md-2"><input type="text" name="largePrice"
                                                     placeholder="<%=goods.getlargePrice()%>"></td>
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
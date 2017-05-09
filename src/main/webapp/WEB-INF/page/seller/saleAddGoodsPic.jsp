<%@ page language="java" contentType="text/html; charset=utf-8" import="com.backend.model.*"
         import="com.backend.sellerEnd.*"
         pageEncoding="utf-8" %>
<%@page errorPage="saleError.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>支农网上生鲜超市</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
    <link href="../bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <script>
        function ret() {
            window.location.href = "saleMain.jsp";
        }

        function infor() {
            alert("商品图片添加成功！");
        }
    </script>
</head>

<body>
<%!
    String addGoodsID;
%>
<%
    addGoodsID = (String) request.getSession().getAttribute("addgoodsid");
%>
<nav class="navbar navbar-default" style="padding:20px">
    <a href="/" class=navbar-brand" style="padding:40px"><span class="glyphicon glyphicon-home">首页</a>
    <button class="btn btn-default" onclick="ret()">返回</button>
</nav>

<div class="container" style="background-color:#CCCCCC">
    <form method="post" action="${pageContext.request.contextPath}/Goods/UploadImage?goodsID=<%=addGoodsID %>"
          enctype="multipart/form-data">
        <div>
            <h4>商品添加成功，请为您的商品添加一张图片：</h4>
            <div class="thumbnail" style="height:220px;width:300px">
                <div style="height:220px;width:220px" overflow:hidden; text-align:center; border:1px solid red;>
                    <img src="/resources/images/default.jpg"
                         class="img-responsive center-block"
                         style="display:inline-block; vertical-align:middle; max-height:220px; max-width:250px;">
                    <p>默认图片</p>
                </div>
            </div>
            <input type="file" name="uploadFile"/>
        </div>
        <div style="padding-top:20px">
            <button type="submit" class="btn btn-primary btn-lg" onclick="infor()">提交图片</button>
        </div>
    </form>
</div>
</body>
</html>
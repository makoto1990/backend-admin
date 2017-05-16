<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/resources/jquery/jquery.min.js"></script>
    <script src="/resources/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<table style="text-align: center" class="table">
    <tr>
    <td><a href="<c:url value="/admin/UserControl" />" class="btn" >UserControl</a></td>
    <td><a href="<c:url value='/admin/GoodsControl' />"class="btn"  >GoodsControl</a></td>
    <td><a href="<c:url value='/admin/OrderControl' />" class="btn" >OrderControl</a></td>
    <td><a href="<c:url value='/admin/SellerControl' />" class="btn" >SellerControl</a></td>
    <td><a href="<c:url value='/admin/CompositionControl' />" class="btn" >CompositionControl</a></td>

    </tr>
</table>

</body>
</html>

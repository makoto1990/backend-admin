<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2017/4/3
  Time: 下午7:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Goods Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
    <script src=/resources/angular/angular.min.js></script>
</head>
<body>
<h1>
    Find a Goods
</h1>
<tr><td><a href="<c:url value='/admin' />" >back</a></td></tr>
<div ng-app="myApp" ng-controller="myCtrl" ng-init="ID=''" >
<c:url var="findAction" value="/admin/GoodsControl/FindGoods/${goods.goodsId}" ></c:url>

<form:form action="${findAction}" commandName="goods">
    <table>
        <tr>
            <td><input type="text" ng-model="ID"></td>
            <td><a href="/admin/GoodsControl/FindGoods/{{ID}}">Find</a></td>
        </tr>

        <c:if test="${!empty goods.goodsName}">
            <tr>
                <th width="80">Goods ID</th>
                <th width="120">Goods Name</th>
                <th width="120">Goods Count</th>
                <th width="120">Goods Price</th>
                <th width="120">Goods Store way</th>
                <th width="120">Goods Source</th>
                <th width="120">Seller ID</th>
                <th width="120">Goods Type</th>
                <th width="120">Least Amount</th>
                <th width="120">Large Amount</th>
                <th width="120">Goods Large Price</th>
                <th width="120">Goods Pricture</th>
                <th width="120">Goods Size</th>
                <th width="120">Goods Intro</th>
                <th width="60">Delete</th>
            </tr>
            <tr>
                <td>${goods.goodsId}</td>
                <td>${goods.goodsName}</td>
                <td>${goods.goodsCount}</td>
                <td>${goods.goodsPrice}</td>
                <td>${goods.storeWay}</td>
                <td>${goods.sourceArea}</td>
                <td>${goods.setDate}</td>
                <td>${goods.sellerId}</td>
                <td>${goods.goodsType}</td>
                <td>${goods.leastAmount}</td>
                <td>${goods.largeAmount}</td>
                <td>${goods.largePrice}</td>
                <td><img src=${goods.picture}/></td>
                <td>${goods.goodsSize}</td>
                <td>${goods.goodsIntro}</td>
                <td><a href="<c:url value='/admin/GoodsControl/RemoveGoods/${goods.goodsId}' />" >Delete</a></td>
            </tr>
        </c:if>

    </table>


</form:form>
</div>
<script>

    var app = angular.module("myApp", []);

    app.controller("myCtrl", function($scope) {
        $scope.myVar = true;
        $scope.toggle = function() {
            $scope.myVar = !$scope.myVar;
        };
    });

</script>
<br>
<h3>User List</h3>
<c:if test="${!empty listGoods}">
    <table class="tg">
        <tr>
            <th width="80">Goods ID</th>
            <th width="120">Goods Name</th>
            <th width="120">Goods Count</th>
            <th width="120">Goods Price</th>
            <th width="120">Goods Store way</th>
            <th width="120">Goods Source</th>
            <th width="120">Seller ID</th>
            <th width="120">Goods Type</th>
            <th width="120">Goods Set Date</th>
            <th width="120">Least Amount</th>
            <th width="120">Large Amount</th>
            <th width="120">Goods Large Price</th>
            <th width="120">Goods Pricture</th>
            <th width="120">Goods Size</th>
            <th width="120">Goods Intro</th>

            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listGoods}" var="goods">
            <tr>
                <td>${goods.goodsId}</td>
                <td>${goods.goodsName}</td>
                <td>${goods.goodsCount}</td>
                <td>${goods.goodsPrice}</td>
                <td>${goods.storeWay}</td>
                <td>${goods.sourceArea}</td>
                <td>${goods.sellerId}</td>
                <td>${goods.goodsType}</td>
                <td>${goods.setDate}</td>
                <td>${goods.leastAmount}</td>
                <td>${goods.largeAmount}</td>
                <td>${goods.largePrice}</td>
                <td><img src=${goods.picture}/></td>
                <td>${goods.goodsSize}</td>
                <td>${goods.goodsIntro}</td>

            <%-- <td><a href="<c:url value='/edit/${goods.goodsID}' />" >Edit</a></td>--%>
            <td><a href="<c:url value='/admin/GoodsControl/RemoveGoods/${goods.goodsId}' />" >Delete</a></td>
        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2017/4/6
  Time: 上午10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" session="false" %>
<html>
<head>
    <title>Composition Page</title>
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
    Add a Composition
</h1>
<tr><td><a href="<c:url value='/admin' />" >back</a></td></tr>
<div ng-app="myApp" ng-controller="myCtrl" ng-init="compositionID=''" ng-init="sellerID=''">

    <c:url var="addAction" value="/admin/CompositionControl/FindCompositionBySellerID/${composition.orderGoodsId}" ></c:url>
    <button ng-click="toggle()">隐藏/显示</button>

    <form:form action="${addAction}" commandName="composition">
        <table ng-show="myVar">
            <tr>
                <td>
                    <input type="text" ng-model="sellerID">

                </td>
                <td><a href="/admin/CompositionControl/FindCompositionBySellerID/{{sellerID}}">FindSeller</a></td>
            </tr>
            <tr>
                <td>
                    <input type="text" ng-model="compositionID">
                </td>
                <td><a href="/admin/CompositionControl/FindSingleComposition/{{compositionID}}">FindId</a></td>
            </tr>
            <c:if test="${!empty composition.goodsAmount}">
                <tr>
                    <th width="80">Composition ID</th>
                    <th width="120">Goods Amount</th>
                    <th width="120">Seller ID</th>
                    <th width="120">Goods ID</th>

                    <th width="60">Delete</th>
                </tr>
                <tr>
                    <td>${composition.orderGoodsId}</td>
                    <td>${composition.goodsAmount}</td>
                    <td>${composition.sellerId}</td>
                    <td>${composition.goodsID}</td>
                    <td><a href="<c:url value='/admin/CompositionControl/RemoveComposition/${composition.orderGoodsId}' />" >Delete</a></td>

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
<h3>Composition List</h3>
<c:if test="${!empty listComposition}">
    <table class="tg">
        <tr>
            <th width="80">Composition ID</th>
            <th width="120">Goods Amount</th>
            <th width="120">Seller ID</th>
            <th width="120">Goods ID</th>


            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listComposition}" var="composition">
            <tr>
                <td>${composition.orderGoodsId}</td>
                <td>${composition.goodsAmount}</td>
                <td>${composition.sellerId}</td>
                <td>${composition.goodsId}</td>

                <td><a href="<c:url value='/admin/CompositionControl/RemoveComposition/${composition.orderGoodsId}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Seller Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
    <script src=/resources/angular/angular.min.js></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/resources/jquery/jquery.min.js"></script>
    <script src="/resources/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>
    Add a Seller
</h1>
<tr><td><a href="<c:url value='/admin/' />" >back</a></td></tr>
<div ng-app="myApp" ng-controller="myCtrl" ng-init="ID=''" >
<c:url var="addAction" value="/admin/SellerControl/AddSeller" ></c:url>
    <c:if test="${!empty seller.userId}">
        <button ng-click="toggle()"class="btn">EDIT</button>
    </c:if>
    <c:if test="${empty seller.userId}">
        <button ng-click="toggle2()"class="btn">ADD</button>
    </c:if>
<form:form action="${addAction}" commandName="seller">
    <table ng-hide="myVar">
        <c:if test="${empty seller.userId}">
            <tr>
                <td>*
                    <form:label path="sellerId">
                        <spring:message text="Seller ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="sellerId" ng-model="sId" class="form-control" />
                    <%--<form:hidden path="sellerId" />--%>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>*
                <form:label path="userId">
                    <spring:message text="User ID" />
                </form:label>
            </td>
            <td>
                <form:input path="userId" ng-model="uId" class="form-control" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="registerDate">
                    <spring:message text="register Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="registerDate" ng-model="Now" disabled="true" class="form-control"  />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sellerIntro">
                    <spring:message text="Seller Intro"/>
                </form:label>
            </td>
            <td>
                <form:input path="sellerIntro"  class="form-control" />
            </td>
        </tr>
        <tr ng-if="uId>100000000&&uId<999999999999&&sId>100000000&&sId<999999999999">
            <td colspan="2">
                <c:if test="${!empty seller.userId}">
                    <input type="submit"
                           value="<spring:message text="Edit Seller"/>" />
                </c:if>
                <c:if test="${empty seller.userId}">
                    <input type="submit"
                           value="<spring:message text="Add Seller"/>" />
                </c:if>
            </td>
        </tr>
    </table>


</form:form>
</div>
<script>

    var app = angular.module("myApp", []);

    app.controller("myCtrl", function($scope) {
        $scope.myVar = true;
        $scope.myVar2 = true;
        $scope.toggle = function() {
            $scope.myVar=!$scope.myVar;
        };
        $scope.toggle2 = function() {
            $scope.myVar = !$scope.myVar;

            $scope.myVar2= !$scope.myVar2;
        };
        var now1=new Date();
        $scope.Now=now1.getUTCFullYear()+'-'+now1.getUTCMonth()+'-'+now1.getUTCDate()+' '+now1.getHours()+':'+now1.getMinutes()+':'+now1.getSeconds();
        $scope.sId="${seller.sellerId}";
        $scope.uId="${seller.userId}";

    });

</script>
<br>
<h3>Seller List</h3>
<c:if test="${!empty listSellers}">
    <table class="tg">
        <tr>
            <th width="80">Seller ID</th>
            <th width="120">User ID</th>
            <th width="120">RegisterDate</th>
            <th width="120">Seller Intro</th>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listSellers}" var="seller">
            <tr>
                <td>${seller.sellerId}</td>
                <td>${seller.userId}</td>
                <td>${seller.registerDate}</td>
                <td>${seller.sellerIntro}</td>

                <td><a href="<c:url value='/admin/SellerControl/EditSeller/${seller.sellerId}' />" >Edit</a></td>
                <td><a href="<c:url value='/admin/SellerControl/RemoveSeller/${seller.sellerId}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
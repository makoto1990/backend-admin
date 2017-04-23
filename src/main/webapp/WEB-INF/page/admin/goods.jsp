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
<%@ page session="false" %>
<html>
<head>
    <title>Goods Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Goods
</h1>

<c:url var="addAction" value="/goods/add" ></c:url>

<form:form action="${addAction}" commandName="goods">
    <table>
        <c:if test="${!empty goods.goodsName}">
            <tr>
                <td>
                    <form:label path="goodsID">
                        <spring:message text="Goods ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="goodsID" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="goodsID" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="goodsName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="goodsName" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="goodsCount">
                    <spring:message text="Count"/>
                </form:label>
            </td>
            <td>
                <form:input path="goodsCount" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="goodsPrice">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="goodsPrice" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="storeWay">
                    <spring:message text="Store Way"/>
                </form:label>
            </td>
            <td>
                <form:input path="storeWay" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sourceArea">
                    <spring:message text="Source Area"/>
                </form:label>
            </td>
            <td>
                <form:input path="sourceArea" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="setDate">
                    <spring:message text="Set Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="setDate" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sellerID">
                    <spring:message text="Seller ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="sellerID" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="goodsType">
                    <spring:message text="Goods Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="goodsType" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="leastAmount">
                    <spring:message text="Least Amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="leastAmount" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="largeAmount">
                    <spring:message text="Large Amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="largeAmount" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="largePrice">
                    <spring:message text="Large Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="largePrice" />
            </td>
        </tr>
       <%-- <tr>
            <td>
                <form:label path="Picture">
                    <spring:message text="picture"/>
                </form:label>
            </td>
            <td>
                <form:input path="Picture" />
            </td>
        </tr>--%>
        <tr>
            <td colspan="2">
                <c:if test="${!empty goods.goodsName}">
                    <input type="submit"
                           value="<spring:message text="Edit Goods"/>" />
                </c:if>
                <c:if test="${empty  goods.goodsName}">
                    <input type="submit"
                           value="<spring:message text="Add Goods"/>" />
                </c:if>
            </td>
        </tr>
    </table>


</form:form>
<br>
<h3>User List</h3>
<c:if test="${!empty listGoodses}">
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
            <th width="120">Least Amount</th>
            <th width="120">Large Amount</th>
            <th width="120">Goods Large Price</th>
            <th width="120">Goods Pricture</th>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listGoodses}" var="goods">
            <tr>
                <td>${goods.goodsID}</td>
                <td>${goods.goodsName}</td>
                <td>${goods.goodsCount}</td>
                <td>${goods.goodsPrice}</td>
                <td>${goods.storeWay}</td>
                <td>${goods.sourceArea}</td>
                <td>${goods.setDate}</td>
                <td>${goods.sellerID}</td>
                <td>${goods.goodsType}</td>
                <td>${goods.leastAmount}</td>
                <td>${goods.largeAmount}</td>
                <td>${goods.largePrice}</td>
                <td><img src=${goods.Picture}/></td>


                <td><a href="<c:url value='/edit/${goods.goodsID}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${goods.goodsID}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Order Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Order
</h1>

<c:url var="addAction" value="/order/add" ></c:url>

<form:form action="${addAction}" commandName="order">
    <table>
        <c:if test="${!empty order.receiverName}">
            <tr>
                <td>
                    <form:label path="orderID">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="orderID" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="orderID" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="receiverName">
                    <spring:message text="Receiver Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="receiverName" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Phone">
                    <spring:message text="phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="Phone" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="orderStatus">
                    <spring:message text="Order Status"/>
                </form:label>
            </td>
            <td>
                <form:input path="orderStatus" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="payTime">
                    <spring:message text="Pay Time"/>
                </form:label>
            </td>
            <td>
                <form:input path="payTime" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="deliveryTime">
                    <spring:message text="Delivery Time"/>
                </form:label>
            </td>
            <td>
                <form:input path="deliveryTime" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="shipCost">
                    <spring:message text="Ship Cost"/>
                </form:label>
            </td>
            <td>
                <form:input path="shipCost" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="allPrice">
                    <spring:message text="All Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="allPrice" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="confirmTime">
                    <spring:message text="Cofirm Time"/>
                </form:label>
            </td>
            <td>
                <form:input path="confirmTime" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Postcode">
                    <spring:message text="postcode"/>
                </form:label>
            </td>
            <td>
                <form:input path="Postcode" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Province">
                    <spring:message text="province"/>
                </form:label>
            </td>
            <td>
                <form:input path="Province" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="City">
                    <spring:message text="city"/>
                </form:label>
            </td>
            <td>
                <form:input path="City" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="District">
                    <spring:message text="district"/>
                </form:label>
            </td>
            <td>
                <form:input path="District" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Street">
                    <spring:message text="street"/>
                </form:label>
            </td>
            <td>
                <form:input path="Street" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Address">
                    <spring:message text="address"/>
                </form:label>
            </td>
            <td>
                <form:input path="Address" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="creatTime">
                    <spring:message text="Creat Time"/>
                </form:label>
            </td>
            <td>
                <form:input path="creatTime" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="userID">
                    <spring:message text="User ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="userID" />
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
            <td colspan="2">
                <c:if test="${!empty User.userName}">
                    <input type="submit"
                           value="<spring:message text="Edit User"/>" />
                </c:if>
                <c:if test="${empty User.userName}">
                    <input type="submit"
                           value="<spring:message text="Add User"/>" />
                </c:if>
            </td>
        </tr>
    </table>


</form:form>
<br>
<h3>User List</h3>
<c:if test="${!empty listOrders}">
    <table class="tg">
        <tr>
            <th width="80">Order ID</th>
            <th width="120">Order ReceiverName</th>
            <th width="120">Order Phone</th>
            <th width="120">Order Status</th>
            <th width="120">Order PayTime</th>
            <th width="120">Order DeliveryTime</th>
            <th width="120">Order ShipCost</th>
            <th width="120">Order All Price</th>
            <th width="120">Order Confirm Time</th>

            <th width="120">Order Postcode</th>
            <th width="120">Order Province</th>
            <th width="120">Order City</th>
            <th width="120">Order District</th>
            <th width="120">Order Street</th>
            <th width="120">Order Address</th>

            <th width="120">Order CreatTime</th>
            <th width="120">Order User ID</th>
            <th width="120">Order Seller ID</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOrders}" var="order">
            <tr>
                <td>${order.orderID}</td>
                <td>${order.receiverName}</td>
                <td>${order.Phone}</td>
                <td>${order.orderStatus}</td>
                <td>${order.payTime}</td>
                <td>${order.deliveryTime}</td>
                <td>${order.shipCost}</td>
                <td>${order.allPrice}</td>
                <td>${order.confirmTime}</td>

                <td>${order.Postcode}</td>
                <td>${order.Province}</td>
                <td>${order.City}</td>
                <td>${order.District}</td>
                <td>${order.Street}</td>
                <td>${order.Address}</td>
                <td>${order.creatTime}</td>
                <td>${order.userID}</td>
                <td>${order.sellerID}</td>

                <td><a href="<c:url value='/edit/${order.orderID}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${order.orderID}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
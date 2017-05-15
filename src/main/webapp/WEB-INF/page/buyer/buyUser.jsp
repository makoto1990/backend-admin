<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ page import="com.backend.buyerEnd.dao.OrderDao,com.backend.model.OrderEntity,java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户页面</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String name = request.getSession().getAttribute("sname").toString();
%>

<%@ include file="header.jsp" %>

<table class="table table-striped">
    <caption>订单信息</caption>
    <thead>
    <tr>
        <th>订单编号</th>
        <th>订单状态</th>
        <th>创建时间</th>
        <th>付款时间</th>
        <th>发货时间</th>
        <th>确认/取消时间</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%
            OrderDao dao = new OrderDao();
            List<OrderEntity> list = dao.getOrderByUserID(name);
            for (OrderEntity o1 : list) {%>
        <td><%=o1.getOrderId() %>
        </td>
        <td><%=o1.getOrderStatus() %>
        </td>
        <td><%=o1.getCreatTime() %>
        </td>
        <td><%=o1.getPayTime() %>
        </td>
        <td><%=o1.getDeliveryTime() %>
        </td>
        <td><%=o1.getConfirmTime() %>
        </td>
        <%
            }
        %>
    </tr>
    </tbody>
</table>


</body>
</html>
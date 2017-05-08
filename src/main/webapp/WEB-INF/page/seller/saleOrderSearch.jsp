<%@ page language="java" import="com.demo.supermarket.*" import="com.demo.supermarketSale.*"
         contentType="text/html; charset=GBK"
         pageEncoding="GBK" %>
<%@page import="java.util.ArrayList" %>
<%@page errorPage="saleError.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>֧ũ�������ʳ���</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
    <link href="../bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <script>
        function ret() {
            window.location.href = "saleMain.jsp";
        }

        function searchbyselect() {
            if (document.getElementById("selectsearchoption").value == "date") {
                document.getElementById("tip").innerHTML = "��ѯ��ʽ�磺 2017-04-03"
            }
            else if (document.getElementById("selectsearchoption").value == "id") {
                document.getElementById("tip").innerHTML = "��ѯ��ʽ�磺201704020001"
            }
            else {
                document.getElementById("tip").innerHTML = "��ѯ��ʽ�磺 �ƹ�"
            }
        }
    </script>


</head>
<body>
<nav class="navbar navbar-default" style="padding:20px">
    <a href="../index.jsp" class=navbar-brand" style="padding:40px"><span class="glyphicon glyphicon-home">��ҳ</a>
    <button class="btn btn-default" onclick="ret()">����</button>
</nav>
<div class="container">


</div>


<div class="container" id="">
    <form action="${pageContext.request.contextPath}/SearchOrderServlet" method="post">
        <div class="input-prepend input-append">
<span class="add-on"><select name="select" id="selectsearchoption" onclick="searchbyselect()" class="selectpicker"
                             style="width:150px ;height:40px">
<option value="id">�������</option>
<option value="date">�µ�����</option>
<option value="name">��Ʒ����</option>
</select></span>

            <input type="text" style="width:300px" name="input" placeholder="�����ѯ���ݣ�֧��ģ����ѯ"
                   class="span2 search-query input-lg">
            <span class="add-on">
<button type="submit" class="btn btn-success" style="width:100px;height:50px"><span class="glyphicon glyphicon-search">��ѯ</span></button>&nbsp;&nbsp;<span
                    id="tip" style="color:#6E6E6E">��ѯ��ʽ�磺201704020001</span>
    </form>
</div>
<%!
    Order order = new Order();

%>
<div class="table-responsive">
    <table class="table table-striped table-hover">
        <caption>��ѯ���</caption>
        <tr>
            <td>�������</td>
            <td>�ջ�������</td>
            <td>����ʱ��</td>
            <td>����״̬</td>
        </tr>

        <%
            ArrayList b = new ArrayList();
            b = (ArrayList) request.getSession().getAttribute("list");
            int k = 0;
            if (b.size() != 0) {
                k = b.size();
            }
            for (int i = 0; i < k; i++) {
                order = (Order) b.get(i);
        %>
        <tr>
            <td>
                <a href="saleOrderDetails.jsp?id=<%=order.getorderID() %>" target="_blank"><%=order.getorderID() %>
                </a></td>
            <td><%=order.getreceiverName()%>
            </td>
            <td><%=order.getcreatTime()%>
            </td>
            <td><%=order.getorderStatus()%>
            </td>
        </tr>
        <% }%>
    </table>


</div>


</body>
</html>
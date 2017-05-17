<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ page import="com.backend.model.UserEntity" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户信息修改</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src=/resources/jquery/jquery.min.js></script>
    <script src=/resources/bootstrap/css/bootstrap.min.css></script>
</head>
<body>
<%
    UserEntity user = (UserEntity) request.getSession().getAttribute("user");
%>
<ul class="nav nav-pills">
    <li><a href="/buyer/">主页<% request.getSession().setAttribute("sname", user.getUserName()); %></a></li>
    <li class="active"><a
            href="/buyer/User/Info">我的信息<% request.getSession().setAttribute("sname", user.getUserName()); %></a></li>
    <li><a href="#">我的购物车</a></li>
    <li><a href="/buyer/DeliveryInfo">我的快递<% request.getSession().setAttribute("sname", user.getUserName()); %></a></li>
    <li class="navbar-right"><a href="/">退出</a></li>
</ul>

<form class="form-horizontal" action="/buyer/User/Update" method="post">
    <div class="form-group">
        <label for="username" class="col-sm-4 control-label">用户昵称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="username" placeholder=<%=user.getUserName() %> />
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-4 control-label">密码</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="password" placeholder=<%=user.getPassword() %> />
        </div>
    </div>
    </div>
    <div class="form-group">
        <label for="password2" class="col-sm-4 control-label">确认密码</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="password2" placeholder="" />
        </div>
    </div>
    <div class="form-group">
        <label for="realname" class="col-sm-4 control-label">真实姓名</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="realname" placeholder=<%=user.getRealName() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="idnumber" class="col-sm-4 control-label">身份证号</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="idnumber" placeholder=<%=user.getiDnumber() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-4 control-label">联系电话</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="phone" placeholder=<%=user.getPhone() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="postcode" class="col-sm-4 control-label">邮编</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="postcode" placeholder=<%=user.getPostcode() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="province" class="col-sm-4 control-label">省</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="province" placeholder=<%=user.getProvince() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-4 control-label">市</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="city" placeholder=<%=user.getCity() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="district" class="col-sm-4 control-label">区/县</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="district" placeholder=<%=user.getDistrict() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="street" class="col-sm-4 control-label">街道</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="street" placeholder=<%=user.getStreet() %>/>
        </div>
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-4 control-label">详细地址</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="address" placeholder=<%=user.getAddress() %>/>
        </div>

        <input type="submit" value="确认修改"/>
    </div>
</form>
<%@ include file="footer.jsp" %>
</html>
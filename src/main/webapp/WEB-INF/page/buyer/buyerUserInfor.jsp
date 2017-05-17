<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ page import="com.backend.model.UserEntity" %>

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
<div class="container">
<%@ include file="header.jsp" %>

<form class="form-horizontal" role="form">
    <%
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("userEntity");
        {%>
    <li class="navbar-middle"><a href="/User/Update">修改信息<% request.getSession().setAttribute("user", userEntity); %></a></li>
    <div class="form-group">
        <label class="col-sm-5 control-label">用户ID</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getUserId()==null?"暂未填写":userEntity.getUserId()) %>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">用户姓名</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getUserName()==null?"暂未填写":userEntity.getUserName()) %>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">密码</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=userEntity.getPassword() %>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">真实姓名</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getRealName()==null?"暂未填写": userEntity.getRealName())%>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">身份证号</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getiDnumber()==null?"暂未填写":userEntity.getiDnumber()) %>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">联系电话</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getPhone()==null?"暂未填写":userEntity.getPhone()) %>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">邮编</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getPostcode()==null?"暂未填写":userEntity.getPostcode() )%>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">省</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getProvince()==null?"暂未填写":userEntity.getProvince() )%>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">市</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getCity()==null?"暂未填写":userEntity.getCity()) %>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">区/县</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getDistrict()==null?"暂未填写":userEntity.getDistrict() )%>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">街道</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getStreet()==null?"暂未填写":userEntity.getStreet()) %>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">详细地址</label>
        <div class="col-sm-7">
            <p class="form-control-static"><%=(userEntity.getAddress()==null?"暂未填写":userEntity.getAddress()) %>
            </p>
        </div>
    </div>

    <%
        }
    %>

</form>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
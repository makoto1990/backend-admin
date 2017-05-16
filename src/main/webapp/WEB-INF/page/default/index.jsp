<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>账号登录</title>
    <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/Login.css" />
</head>
<body>
${sessionScope.message}
<br>

<div id="login">
    <h1>欢迎，从这里登录</h1>
    <form:form action="/" method="post" commandName="user">
        <form:input path="userName" type="text" class="loginInput" required="required" placeholder="用户名"  name="username"></form:input>
        <form:input path="password" type="password" class="loginInput" required="required" placeholder="密码" name="password"></form:input>
        <label class="checkbox-inline">
            <input type="radio" name="style" id="op1" value="1" >我是买家
            <input type="radio" name="style" id="op2"  value="2">我是卖家
            <input type="radio" name="style"  id="op3" value="3">管理员
        </label>
        <div>
            <input value="登录" class="button" type="submit"/>
            <input value="注册" class="button" type="button" onclick="window.location.href='/register'"/>
        </div>
    </form:form>
</div>
</body>
</html>
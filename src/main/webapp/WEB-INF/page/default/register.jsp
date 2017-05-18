<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/register.css" />
    <title>账号注册</title>
</head>
<body>

<div id="login">
    <h1>欢迎，从这里注册</h1>
    <form:form action="/register" method="post" commandName="user">
        <form:input path="userName" type="text" class="loginInput" required="required" placeholder="用户名"  name="username"></form:input>
        <form:input path="password" type="password" class="loginInput" required="required" placeholder="密码" name="password"></form:input>

        <div class="btnDiv">
            <button class="button" type="submit">注册</button>
            <button class="button" type="reset">重置</button>
        </div>

    </form:form>
</div>

</body>
</html>
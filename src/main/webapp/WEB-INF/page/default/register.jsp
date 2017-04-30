<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>支农网上生鲜超市</title>
</head>
<body>
<form:form action="/register" method="post" commandName="user">

    用户注册：
    <table>
        <tr>
            <td>用户名:</td>
            <td><form:input path="userName" type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><form:input path="password" type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
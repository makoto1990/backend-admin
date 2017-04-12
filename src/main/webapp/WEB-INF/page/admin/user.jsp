<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2017/4/3
  Time: 下午7:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>User Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Person
</h1>

<c:url var="addAction" value="/admin/UserControl/Add" ></c:url>

<form:form action="${addAction}" commandName="user">
    <table>
        <c:if test="${!empty user.userName}">
            <tr>
                <td>
                    <form:label path="userID">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="userID" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="userID" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="userName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="userName" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="Password"/>
                </form:label>
            </td>
            <td>
                <form:input path="password" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="realName">
                    <spring:message text="RealName"/>
                </form:label>
            </td>
            <td>
                <form:input path="realName" />
            </td>
        </tr>
        <tr>
        <td>
            <form:label path="IDnumber">
                <spring:message text="IDNumber"/>
            </form:label>
        </td>
        <td>
            <form:input path="IDnumber" />
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
            <form:label path="userStatus">
                <spring:message text="UserStatus"/>
            </form:label>
        </td>
        <td>
            <form:input path="userStatus" />
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
                <form:label path="isManager">
                    <spring:message text="IsManager"/>
                </form:label>
            </td>
            <td>
                <form:input path="isManager" />
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
<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">User ID</th>
            <th width="120">User Name</th>
            <th width="120">User RegisterDate</th>
            <th width="120">User password</th>
            <th width="120">User Real Name</th>
            <th width="120">User ID number</th>
            <th width="120">User Phone</th>
            <th width="120">User Postcode</th>
            <th width="120">User Province</th>
            <th width="120">User City</th>
            <th width="120">User District</th>
            <th width="120">User Street</th>
            <th width="120">User Address</th>
            <th width="120">User isManager</th>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.userID}</td>
                <td>${user.userName}</td>
                <td>${user.registerDate}</td>
                <td>${user.password}</td>
                <td>${user.realName}</td>
                <td>${user.IDnumber}</td>
                <td>${user.Phone}</td>
                <td>${user.userStatus}</td>
                <td>${user.Postcode}</td>
                <td>${user.Province}</td>
                <td>${user.City}</td>
                <td>${user.District}</td>
                <td>${user.Street}</td>
                <td>${user.Address}</td>
                <td>${user.isManager}</td>

                <td><a href="<c:url value='/edit/${user.userID}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${user.userID}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
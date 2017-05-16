<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.ArrayList"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script>
    $(document).ready(function () {
        // put all your jQuery goodness in here.
    });
</script>
<div id="header">
    <div class="row clearfix">
        <div class="col-md-12 column" style="background: #ffffff">
            <table>
                <tr>
                    <td><img alt="" src="/resources/images/logo.jpg"/>
        </div>
        </td>
        <td>
            <ul class="nav nav-pills">
                <li class="active"><a href="/buyer/">主页</a></li>
                <li><a href="/buyer/User/Info">我的信息</a></li>
                <li><a href="/buyer/Cart">购物车</a></li>
                <li><a href="/buyer/DeliveryInfo">我的快递</a></li>
                <li class="navbar-right"><a href="/">退出</a>
                </li>
            </ul>
        </td>
        </tr>
        <tr>
            <td>一排宣传的照片</td>
        </tr>
        </table>
    </div>
</div>
</div>

<!-- 第二部分 导航栏-->
<div id="topmenu">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle"
                                data-toggle="collapse" data-target="#example-navbar-collapse">
                            <span class="sr-only">切换导航</span> <span class="icon-bar"></span>
                            <span class="icon-bar"></span> <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/buyer/">首页</a>
                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <%
                                ArrayList<String> typeList = (ArrayList) request.getSession().getAttribute("goodsTypes");
                                int size = typeList.size();
                                String[] typeNames = (String[]) typeList.toArray(new String[size]);
                                int i = 0;
                                for (String typeName : typeNames) {
                            %>
                            <li><a href="#"><%=typeName%>
                            </a></li>
                            <%
                                    i++;
                                }%>

                        </ul>
                        <form class="navbar-form navbar-right" role="search" action="/buyer/Search" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="请输入你想要搜索的商品类别或商品名称"
                                       id="searchinfo">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
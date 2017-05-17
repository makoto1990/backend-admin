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
   <div class="col-lg-6 col-xs-4 col-sm-3">


        <img alt="" src="/resources/images/logo.jpg"/>
   </div>
        <div  class="col-lg-6 col-xs-8  col-sm-3">
            <table height="80">
        <td>
            <ul class="nav nav-pills">
                <li ><a href="/buyer/">主页</a></li>
                <li><a href="/buyer/User/Info">我的信息</a></li>
                <li><a href="/buyer/Cart">购物车</a></li>
                <li><a href="/buyer/DeliveryInfo">我的快递</a></li>
                <li class="navbar-right"><a href="/">退出</a>
                </li>
            </ul>
        </td>
        </tr>
        </table>
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
                        <form class="navbar-form navbar-right" role="search" action="/buyer/Search" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="输入内容"
                                       name="searchinfo">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
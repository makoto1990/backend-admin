<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script language="javascript">
        var cTime = 5;//这个变量是倒计时的秒数设置为10就是10秒
        function TimeClose() {
            window.setTimeout('TimeClose()', 1000);//让程序每秒重复执行当前函数。
            if (cTime <= 0)//判断秒数如果为0
                window.location.href = "../index.jsp";
            ;//执行关闭网页的操作
            document.getElementById("infor").innerHTML = "会话已过期，" + cTime + "秒后将返回登陆页面！";//显示倒计时时间
            cTime--;//减少秒数
        }

        function ret() {
            window.location.href = "../index.jsp";
        }
    </script>

</head>
<body onLoad="TimeClose();">
<div align="center" class="container" style="background-color: #E5E5E5;">
    <h3 id="infor">服务器走神了，5秒后将返回登陆页面！</h3>
    <button onclick="ret()" class="btn btn-default">确定</button>
</div>

</body>
</html>
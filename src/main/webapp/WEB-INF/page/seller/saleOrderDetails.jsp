<%@ page language="java" import="com.backend.model.*" import="com.backend.sellerEnd.*"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.backend.sellerEnd.service.SearchService" %>
<%@page errorPage="saleError.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>支农网上生鲜超市</title>
    <script type="text/javascript" src="/resources/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <link href="/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <script>
        function cancelinfor() {
            alert("订单已成功取消！")
        }
        function confirminfor() {
            alert("订单已成功确认，请尽快发货！")
        }
        function sendinfor() {
            alert("订单已成功发货！")
        }
    </script>

</head>
<body>


<%!
    String id;
    ArrayList list = new ArrayList();
    ArrayList goodsList = new ArrayList();
    OrderEntity order = new OrderEntity();
    GoodsEntity goods = new GoodsEntity();
    CompositionEntity composition = new CompositionEntity();
    String status;
%>

<%
    id = (String)request.getSession().getAttribute("id");
    SearchService searchService = (SearchService) request.getSession().getAttribute("searchService");
    list = searchService.SearchOrderDetails(id);
    goodsList = searchService.SearchOrderGood(id);
    order = (OrderEntity) list.get(0);
    status = order.getOrderStatus().trim();

%>
<div class="container">
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <caption style="font-size:30px;padding:30px;color:#0000FF">订单详情</caption>
            <tr style="color:#FF0000;background-color:#D3D3D3">
                <td>订单编号</td>
                <td>收货人姓名</td>
                <td>联系方式</td>
                <td>订单状态</td>
            </tr>

            <tr>
                <td><%=order.getOrderId() %>
                </td>
                <td><%=order.getReceiverName() %>
                </td>
                <td><%=order.getPhone() %>
                </td>
                <td id="status"><%=status %>
                </td>
            </tr>

            <tr style="color:#FF0000;background-color:#D3D3D3">
                <td>创建时间</td>
                <td>付款时间</td>
                <td>确认时间</td>
                <td>发货时间</td>
            </tr>

            <tr>
                <td><%=order.getCreatTime() %>
                </td>

                <% if (order.getPayTime() == null) { %>
                <td>未付款</td>
                <%} else { %>
                <td><%=order.getPayTime() %>
                </td>
                <%} %>

                <% if (order.getConfirmTime() == null) { %>
                <td>未确认</td>
                <%} else { %>
                <td><%=order.getConfirmTime()%>
                </td>
                <%} %>

                <% if (order.getDeliveryTime() == null) { %>
                <td>未发货</td>
                <%} else { %>
                <td><%=order.getDeliveryTime() %>
                </td>
                <%} %>
            </tr>

        </table>
    </div>
</div>

<div class="container">
    <div class="table-responsive" style="padding-bottom:20px">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" align="center" style="padding:20px"
           class="tooltip-test" data-toggle="tooltip" title="点击展开/折叠订单中包含的商品列表">商品列表</a>
        <div id="collapseOne" class="panel-collapse collapse ">
            <div class="panel-body">
                <table class="table table-striped table-hover">
                    <tr style="color:#FF0000;background-color:#90EE90">
                        <td>商品编号</td>
                        <td>商品名称</td>
                        <td>商品类别</td>
                        <td>商品单价</td>
                        <td>商品数量</td>
                        <td>商品总价</td>
                            <%
            for(int i=0;i<goodsList.size();i+=2){
              goods=(GoodsEntity) goodsList.get(i);
	          composition=(CompositionEntity) goodsList.get(i+1);
            %>
                    <tr>
                        <td><a href="#"><%=goods.getGoodsId() %>
                        </a></td>
                        <td><%=goods.getGoodsName() %>
                        </td>
                        <td><%=goods.getGoodsType() %>
                        </td>
                        <td><%=goods.getGoodsPrice() %>
                        </td>
                        <td><%=composition.getGoodsAmount() %>
                        </td>
                        <td><%=goods.getGoodsPrice() * composition.getGoodsAmount() %>
                        </td>
                    </tr>
                    <%} %>
                </table>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="table-responsive">
        <table class="table table-striped table-hover">

            <tr style="color:#FF0000;background-color:#D3D3D3">
                <td>运费</td>
                <td>合计价格</td>
            </tr>

            <tr>
                <td><%=order.getShipCost() %>
                </td>
                <td><%=order.getAllPrice() %>
                </td>
            </tr>
        </table>
    </div>
</div>


<div class="container">
    <div class="table-responsive">
        <table class="table table-striped table-hover">

            <tr style="color:#FF0000;background-color:#D3D3D3">
                <td>收货地址</td>
                <td>邮编</td>
            </tr>

            <tr>
                <td><%=order.getProvince() %>-<%=order.getCity() %>-<%=order.getDistrict() %>-<%=order.getStreet() %>
                    -<%=order.getAddress() %>-<%=order.getDistrict() %>
                </td>
                <td><%=order.getPostcode() %>
                </td>
            </tr>

        </table>
        <div>
            <%if (!status.equals("订单已取消")) {%>
            <form action="/seller/Order/Update" align="right">
                <input type="text" name="contro" value="0" style="display:none">
                <input type="text" name="id" value="<%=order.getOrderId() %>" style="display:none">
                <input type="submit" style="width:150px;height:50px" class="btn btn-warning" onclick="cancelinfor()"
                       value="取消订单"/>
            </form>
            <%} %>
            <p></p>
            <%if (status.equals("等待卖家确认")) {%>
            <form action="/seller/Order/Update" align="right">
                <input type="text" name="contro" value="1" style="display:none">
                <input type="text" name="id" value="<%=order.getOrderId() %>" style="display:none">
                <input type="submit" style="width:150px;height:50px" class="btn btn-primary" onclick="confirminfor()"
                       value="确认订单"/>
            </form>
            <%
                }
                if (status.equals("等待卖家发货")) {
            %>
            <p></p>
            <form action="/seller/Order/Update" align="right">
                <input type="text" name="contro" value="2" style="display:none">
                <input type="text" name="id" value="<%=order.getOrderId() %>" style="display:none">
                <input type="submit" style="width:150px;height:50px" class="btn btn-primary" onclick="sendinfor()"
                       value="发货"/>
            </form>
            <%} %>
        </div>
    </div>
</div>


</body>
</html>
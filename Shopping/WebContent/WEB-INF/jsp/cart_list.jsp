<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车详情</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index_work.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
      $(function (){
    	  $(".del").click(function (){
			  $.post(
				    "<%=request.getContextPath()%>/cart/deleteGoods",
				    {
				    	gid:$(this).prev().val(),
				    	buyCount:$(this).parent().prev().text()
				    },
				    function (obj){
				    	if(obj){
				    		alert("移除成功!");
				    		location="<%=request.getContextPath()%>/cart/getCartList";
				    	} else {
				    		alert("移除失败!");
				    	}
				    },
				    "json"
			  );
		  });
      })
</script>
</head>
<body>
      <center>
            <table border="1" cellspacing="0" cellpadding="0" width="60%">
                   <tr>
                          <th colspan="10">购物车详情</th>
                   </tr>
                   <c:if test="${cartList.size()==0 }">
                          <tr>
                                 <th colspan="10">购物车中暂无商品!</th> 
                          </tr>
                   </c:if>
                   <c:if test="${cartList.size()!=0 }">
                          <tr>
                                 <th>商品编号</th>
                                 <th>商品名称</th>
                                 <th>商品单价</th>
                                 <th>购买数量</th>
                                 <th>操作<input type="button" value="返回商品列表" onclick="location='<%=request.getContextPath()%>/cart/getGoodsList'"></th>
                          </tr>
                          <c:set var="total" value="0"></c:set>
                          <c:forEach items="${cartList }" var="cart">
                                 <tr>
                                        <td>${cart.gid }</td>
                                        <td>${cart.gname }</td>
                                        <td>￥${cart.gprice }</td>
                                        <td>${cart.buyCount }</td>
                                        <c:set var="total" value="${total+cart.sum }"></c:set>
                                        <td>
                                               <input type="hidden" value="${cart.gid }">
                                               <input type="button" value="移除商品" class="del">
                                        </td>
                                 </tr>
                          </c:forEach>
                          <tr>
                                 <td colspan="10" style="text-align:right">商品总价:￥${total }</td>
                          </tr>
                   </c:if>
            </table>
     </center>
</body>
</html>
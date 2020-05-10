<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息列表</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index_work.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
      $(function (){
    	  $(".add").click(function (){
    		  var buyCount = Number($(this).parent().prev().find(":input").val());
    		  var gcount = Number($(this).next().val());
    		  if(gcount==0){
	  			    alert("该商品已无存货,请选择其他商品!");
	  		  } else if(buyCount==null||buyCount==""){
	  			    alert("请输入购买数量!");
	  		  } else if(buyCount>gcount){
	  			    alert("购买数量超过库存量,无法购买!");
	  		  } else {
	  			    $.post(
	  			          "<%=request.getContextPath() %>/cart/insertGoods",
	  			          {
	  			        	  gid:$(this).prev().val(),
	  			        	  buyCount:buyCount
	  			          },
	  			          function (obj){
	  			        	  if(obj){
	  			        		  alert("添加成功!");
	  			        		  location="<%=request.getContextPath() %>/cart/getGoodsList";
	  			        	  } else {
	  			        		  alert("添加失败!");
	  			        	  }
	  			          }, "json"
	  			    );
	  		 }
	  	 });
    	  
    	 $("#cart").click(function (){
    		 location="<%=request.getContextPath() %>/cart/getCartList";
    	 });
    	 
      })
</script>
</head>
<body>
     <center>
           <table border="1" cellspacing="0" cellpadding="0" width="60%">
                  <tr>
                         <th colspan="10">商品信息列表</th>
                  </tr>
                  <tr>
                         <th>编号</th>
                         <th>商品名称</th>
                         <th>商品数量</th>
                         <th>商品单价</th>
                         <th>购买数量</th>
                         <th>
                               <input type="button" value="查看购物车" id="cart">
                         </th>
                  </tr>
                  <c:forEach items="${goodsList }" var="goods" varStatus="i">
                         <tr>
                               <td>${i.count }</td>
                               <td>${goods.gname }</td>
                               <td>${goods.gcount }</td>
                               <td>￥${goods.gprice }</td>
                               <td><input type="text" name="buyCount"></td>
                               <td>
                                      <input type="hidden" value="${goods.gid }">
                                      <input type="button" value="添加购物车" class="add">
                                      <input type="hidden" value="${goods.gcount }">
                               </td>
                         </tr>
                  </c:forEach>
           </table>
     </center>
</body>
</html>
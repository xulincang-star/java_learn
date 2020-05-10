package com.baidu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.entity.Cart;
import com.baidu.entity.Goods;
import com.baidu.service.ICartService;

@Controller
@RequestMapping("/cart/")
public class CartController {

	@Resource
	private ICartService cartService;
	
	//查询商品信息列表123
	@RequestMapping("getGoodsList")
	public String getGoodsList(HttpServletRequest request){
		List<Goods> goodsList = cartService.getGoodsList();
		request.setAttribute("goodsList", goodsList);
		return "goods_list";
	}
	
	//向购物车添加商品gid及购物车里商品数量
	@RequestMapping("insertGoods")
	@ResponseBody
	public boolean insertGoods(Cart cart){
		int count = cartService.insertGoods(cart);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	//查询购物车信息列表   商品名称价格数量+总价
	@RequestMapping("getCartList")
	public String getCartList(HttpServletRequest request){
		List<Cart> cartList = cartService.getCartList();
		request.setAttribute("cartList", cartList);
		return "cart_list";
	}
	
	//根据购物车里商品gid移除购物车内的商品
	@RequestMapping("deleteGoods")
	@ResponseBody
	public boolean deleteGoods(Cart cart){
		int count = cartService.deleteGoods(cart);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}

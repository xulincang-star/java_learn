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
	
	//��ѯ��Ʒ��Ϣ�б�123
	@RequestMapping("getGoodsList")
	public String getGoodsList(HttpServletRequest request){
		List<Goods> goodsList = cartService.getGoodsList();
		request.setAttribute("goodsList", goodsList);
		return "goods_list";
	}
	
	//���ﳵ�����Ʒgid�����ﳵ����Ʒ����
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
	
	//��ѯ���ﳵ��Ϣ�б�   ��Ʒ���Ƽ۸�����+�ܼ�
	@RequestMapping("getCartList")
	public String getCartList(HttpServletRequest request){
		List<Cart> cartList = cartService.getCartList();
		request.setAttribute("cartList", cartList);
		return "cart_list";
	}
	
	//���ݹ��ﳵ����Ʒgid�Ƴ����ﳵ�ڵ���Ʒ
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

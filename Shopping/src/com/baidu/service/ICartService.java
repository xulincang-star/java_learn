package com.baidu.service;

import java.util.List;

import com.baidu.entity.Cart;
import com.baidu.entity.Goods;

public interface ICartService {

	List<Goods> getGoodsList();  //查询商品信息列表
	
	int insertGoods(Cart cart);  //向购物车添加商品gid及购物车里商品数量
	
	//Cart getCartById(int gid);   //根据商品gid查询购物车里商品gid
	
	//int updateGoods(Cart cart);  //修改购物车里商品数量(增加)
	
	//int changeGoodsCount(Cart cart); //修改商品信息列表  商品数量(减少)
	
	List<Cart> getCartList();   //查询购物车信息列表   商品名称价格数量+总价
	
	int deleteGoods(Cart cart); //根据购物车里商品gid移除购物车内的商品
	
	//int updateGoodsCount(Cart cart);  //修改商品信息列表  商品数量(增加)
}

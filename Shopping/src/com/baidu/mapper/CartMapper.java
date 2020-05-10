package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.entity.Cart;
import com.baidu.entity.Goods;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface CartMapper {

	List<Goods> getGoodsList();  //查询商品信息列表
	
	int insertGoods(Cart cart);  //向购物车添加商品gid及购物车里商品数量
	
	Cart getCartById(int gid);   //根据商品gid查询购物车里商品gid
	
	int updateGoods(Cart cart);  //修改购物车里商品数量(增加)
	
	int changeGoodsCount(Cart cart); //修改商品信息列表  商品数量(减少)
	
	List<Cart> getCartList();   //查询购物车信息列表   商品名称价格数量+总价
	
	int deleteGoods(@Param("gid") int gid); //根据购物车里商品gid移除购物车内的商品
	
	int updateGoodsCount(Cart cart);  //修改商品信息列表  商品数量(增加)
}

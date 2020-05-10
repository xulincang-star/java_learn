package com.baidu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.entity.Cart;
import com.baidu.entity.Goods;
import com.baidu.mapper.CartMapper;

@Service
@Transactional
public class CartService implements ICartService {

	@Resource
	private CartMapper cartMapper;
	
	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return cartMapper.getGoodsList();
	}

	@Override
	public int insertGoods(Cart cart) {
		int count = 0;
		Cart carts = cartMapper.getCartById(cart.getGid());
		if(carts==null){
			count = cartMapper.insertGoods(cart);
		}else{
			count = cartMapper.updateGoods(cart);
		}
		count+=cartMapper.changeGoodsCount(cart);
		return count;
	}

	@Override
	public List<Cart> getCartList() {
		// TODO Auto-generated method stub
		return cartMapper.getCartList();
	}

	@Override
	public int deleteGoods(Cart cart) {
		int count = cartMapper.deleteGoods(cart.getGid());
		count+=cartMapper.updateGoodsCount(cart);
		return count;
	}

}

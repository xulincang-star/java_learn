package com.baidu.entity;

public class Cart extends Goods {

	private int buyCount;  //购物车里商品数量
	private double sum;   //购物车里商品总价
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
}

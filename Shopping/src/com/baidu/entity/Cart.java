package com.baidu.entity;

public class Cart extends Goods {

	private int buyCount;  //���ﳵ����Ʒ����
	private double sum;   //���ﳵ����Ʒ�ܼ�
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

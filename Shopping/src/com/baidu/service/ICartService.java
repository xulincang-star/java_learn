package com.baidu.service;

import java.util.List;

import com.baidu.entity.Cart;
import com.baidu.entity.Goods;

public interface ICartService {

	List<Goods> getGoodsList();  //��ѯ��Ʒ��Ϣ�б�
	
	int insertGoods(Cart cart);  //���ﳵ�����Ʒgid�����ﳵ����Ʒ����
	
	//Cart getCartById(int gid);   //������Ʒgid��ѯ���ﳵ����Ʒgid
	
	//int updateGoods(Cart cart);  //�޸Ĺ��ﳵ����Ʒ����(����)
	
	//int changeGoodsCount(Cart cart); //�޸���Ʒ��Ϣ�б�  ��Ʒ����(����)
	
	List<Cart> getCartList();   //��ѯ���ﳵ��Ϣ�б�   ��Ʒ���Ƽ۸�����+�ܼ�
	
	int deleteGoods(Cart cart); //���ݹ��ﳵ����Ʒgid�Ƴ����ﳵ�ڵ���Ʒ
	
	//int updateGoodsCount(Cart cart);  //�޸���Ʒ��Ϣ�б�  ��Ʒ����(����)
}

package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.entity.Cart;
import com.baidu.entity.Goods;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface CartMapper {

	List<Goods> getGoodsList();  //��ѯ��Ʒ��Ϣ�б�
	
	int insertGoods(Cart cart);  //���ﳵ�����Ʒgid�����ﳵ����Ʒ����
	
	Cart getCartById(int gid);   //������Ʒgid��ѯ���ﳵ����Ʒgid
	
	int updateGoods(Cart cart);  //�޸Ĺ��ﳵ����Ʒ����(����)
	
	int changeGoodsCount(Cart cart); //�޸���Ʒ��Ϣ�б�  ��Ʒ����(����)
	
	List<Cart> getCartList();   //��ѯ���ﳵ��Ϣ�б�   ��Ʒ���Ƽ۸�����+�ܼ�
	
	int deleteGoods(@Param("gid") int gid); //���ݹ��ﳵ����Ʒgid�Ƴ����ﳵ�ڵ���Ʒ
	
	int updateGoodsCount(Cart cart);  //�޸���Ʒ��Ϣ�б�  ��Ʒ����(����)
}

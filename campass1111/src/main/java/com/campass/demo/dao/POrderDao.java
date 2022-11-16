package com.campass.demo.dao;


import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.entity.PdtOrder;

@Mapper
public interface POrderDao {

	// 주문처리 
	public Integer orderSave(PdtOrder porder);

	// 총합 업데이트
	public Integer totalPriceUpdate(Integer pOrderNo, Integer totalPrice, String username);
	
	// 장바구니 전체삭제(주문 후)
	public Integer cartAllDelete(String username);

}
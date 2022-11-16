package com.campass.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.BuyListDto;

@Mapper
public interface BuyListDao {
	// 장바구니 목록 가져오기
	public List<BuyListDto.BuyList> buylistGet(Integer pOrderNo, String username);
	
	// 주문상태 변경
	public Integer updateStatus(Integer pOdtNo);
}

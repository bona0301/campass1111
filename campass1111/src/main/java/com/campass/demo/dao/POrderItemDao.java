package com.campass.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.POrderItemDto;
import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.entity.pOrderItem;

@Mapper
public interface POrderItemDao {
	
	// 주문상품 추가
	public Integer orderItemSave(pOrderItem pOrderItem);
	
	// 장바구니 목록 가져오기
	public List<PdtCartDto.list> cartListGet(String username);

	// 상품 가격,수량 가져오기
	public List<POrderItemDto.PriceDto> pdtPriceCountGet(Integer pOrderNo, String username);
		
	// 주문번호 목록 가져오기
	public Integer OrderItemByOrder(Integer pOrderNo);
	
	// 주문내역 삭제
	public Integer pOrderItemDelete(Integer pOrderNo, String username);
}

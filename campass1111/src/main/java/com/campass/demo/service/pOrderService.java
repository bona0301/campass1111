package com.campass.demo.service; 


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.POrderDao;
import com.campass.demo.dao.POrderItemDao;
import com.campass.demo.dao.PdtCartDao;
import com.campass.demo.dto.POrderDto;
import com.campass.demo.dto.POrderItemDto;
import com.campass.demo.entity.PdtOrder;
import com.campass.demo.entity.pOrderItem;

@Service
public class pOrderService {
	
	@Autowired
	POrderItemDao itemdao;
	
	@Autowired
	POrderDao orderdao;
	
	@Autowired
	PdtCartDao cartdao;
	
	// 주문상품 추가
	public PdtOrder orderSave(POrderDto.orderSave ordersavedto) {
		
		PdtOrder porder = ordersavedto.toentity();
		
		porder.addTotalPrice(0);
		
		orderdao.orderSave(porder);
		//장바구니에서 데이터 가져와 상세에 각각 담기 
		for(int i=0; i<cartdao.cartListSize(ordersavedto.getUsername());i++) {
			POrderItemDto.SaveDto dto = POrderItemDto.SaveDto
					.builder().pOrderNo(porder.getPOrderNo())
					.pCode(itemdao.cartListGet(ordersavedto.getUsername()).get(i).getPCode())
					.pdtCartAmo(itemdao.cartListGet(ordersavedto.getUsername()).get(i).getPdtCartAmo())
					.build();
			pOrderItem result = dto.toEntity();
			itemdao.orderItemSave(result);
		}
		
		// 상품 가격,수량 리스트에 담기 
		List<Integer> total = new ArrayList<>();
		int totalPirce = 0; 		
		List<POrderItemDto.PriceDto> value = itemdao.pdtPriceCountGet(porder.getPOrderNo(), porder.getUsername());
		
	
		// 주문번호 목록 가져와서 금액 계산  
		for(int i=0; i< itemdao.OrderItemByOrder(porder.getPOrderNo()); i++) {
			int count = value.get(i).getPdtCartAmo();
			int price = value.get(i).getPPrice();
			
			total.add(i, count * price);
	}
		for(int i=0; i<total.size(); i++) {
			totalPirce = totalPirce + total.get(i);
		}
		
		porder.addTotalPrice(totalPirce);
		
		// 금액 업데이트
		orderdao.totalPriceUpdate(porder.getPOrderNo(),porder.getTotalPrice(),porder.getUsername());
		//장바구니 삭제
		orderdao.cartAllDelete(ordersavedto.getUsername());
		
		return porder;
}
	


	}
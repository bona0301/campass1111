package com.campass.demo.dto;

import com.campass.demo.entity.pOrderItem;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class POrderItemDto {

	@Data
	@Builder
	public static class SaveDto {
		private Integer pOrderNo;		//주문번호
		private Integer pCode;			//용품코드
		private Integer pdtCartAmo;		//용품수량	
		
		public pOrderItem toEntity() {
			return pOrderItem.builder().pOrderNo(pOrderNo). pCode(pCode). pdtCartAmo(pdtCartAmo).build();
		}
}
	
	@Data
	public static class PriceDto {
		private Integer pCode;
		private Integer pPrice;
		private Integer pdtCartAmo;
	}
}

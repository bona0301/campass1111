package com.campass.demo.dto;


import com.campass.demo.entity.PdtOrder;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class POrderDto {	
	
	//주문하기
	@Data
	@Builder
	public static class orderSave {
		private String username;			//회원아이디
		private String shipName;			//주문자명
		private String shipAddr;			//배송주소
		
		public PdtOrder toentity() {
			return PdtOrder.builder().username(username).shipName(shipName).shipAddr(shipAddr).build();
		}
}
}


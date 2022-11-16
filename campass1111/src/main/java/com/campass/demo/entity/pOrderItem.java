package com.campass.demo.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class pOrderItem {
	private Integer pOdtNo; 		//주문용품번호
	private Integer pOrderNo;		//주문번호
	private Integer pCode;			//용품코드
	private Integer pdtCartAmo;		//용품수량	
	private String pOrderStatus;	// 주문상태
	
}
	

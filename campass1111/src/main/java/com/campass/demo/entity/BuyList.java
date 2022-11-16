package com.campass.demo.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class BuyList {
	private LocalDate pOrderDate;		// 주문날짜
	private String pBrand;				// 주문용품브랜드
	private String pName;				// 주문용품이름
	private Integer pPrice;				// 주문용품가격
	private Integer pdtCartAmo;			// 주문용품수량
	private String pOrderStatus;	// 주문용품상태
	private Integer pOdtNo; 			// 주문용품번호
	private Integer pCode;				// 용품코드

//	public void addinfo(OrderStatus status) {
//		this.pOrderStatus = status;
//	}
}

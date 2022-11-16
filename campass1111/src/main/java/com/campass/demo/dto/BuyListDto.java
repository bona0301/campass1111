package com.campass.demo.dto;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuyListDto {
	// 구매내역 가져오기
	@Data
	public static class BuyList{
		private LocalDate pOrderDate;		// 주문날짜
		private String pMainImg;			// 용품사진
		private String pBrand;				// 용품브랜드
		private String pName;				// 주문용품이름
		private Integer pPrice;			// 주문용품가격
		private Integer pdtCartAmo;			// 주문용품수량
		private String pOrderStatus;	// 주문용품상태
		private Integer pOdtNo; 			// 주문용품번호
		private Integer pOrderNo;			// 주문번호
		private Integer pCode;				// 용품코드	
	}
}

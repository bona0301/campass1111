package com.campass.demo.controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.POrderDto;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.BuyerService;
import com.campass.demo.service.pOrderService;


@RestController
@RequestMapping(value="/buyer")
public class BuyerPOrderController {
	
	@Autowired
	private pOrderService service;
	
	@Autowired
	private BuyerService bservice;

	// 주문하기 
	@PostMapping("/product/order/add")
	public ResponseEntity<ResponseDto> order(POrderDto.orderSave orderSavedto) {
		System.out.println(orderSavedto);
		System.out.println(service.orderSave(orderSavedto));
		return ResponseEntity.ok(new ResponseDto("상품 주문 완료 입니다", service.orderSave(orderSavedto)));
	}
	

	
	// 회원정보 가져오기
	@GetMapping(value = "product/order/buyerinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> buyerinfo(Principal principal) {
		
		return ResponseEntity.ok(new ResponseDto(principal.getName(), bservice.buyerInfo(principal.getName())));
	}
	

}

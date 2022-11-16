package com.campass.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.campass.demo.OrderStatus;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.BuyListService;

@Controller
@RequestMapping(value="/buyer")
public class BuyerBuyListController {
	@Autowired
	BuyListService service;
	
	// 구매내역 출력 
	@GetMapping(value = "/product/buylist", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> buylistGet(Integer pOdtNo, Principal principal) {
		return ResponseEntity.ok(new ResponseDto("주문내역 출력", service.buylistGet(pOdtNo, principal.getName())));
	}
	

 }

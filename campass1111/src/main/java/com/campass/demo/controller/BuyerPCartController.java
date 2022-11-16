package com.campass.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.PCartService;

@RestController
@RequestMapping(value="/buyer")
public class BuyerPCartController {
	
	@Autowired 	
	private PCartService service;
	
	// 장바구니 추가 
	@PostMapping("/product/pcart/add")
	public String addCartPOST(PdtCartDto.pAddCart cart, HttpServletRequest request) throws Exception {
		// 카트 등록
		String result = service.pAddCart(cart);
		
		return result + "";
	}

	
	//	장바구니 리스트
	@GetMapping(value = "/pcart/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PdtCartDto.Read>> listCart(Principal principal){ // 로그인 아이디로 대체
	
		return ResponseEntity.ok(service.listCart(principal.getName()));
	 }

	// 수량변경
	@PutMapping(value = "/pcart/countupdate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> update(PdtCartDto.cartCountUpdate dto, Principal principal){
		
		return ResponseEntity.ok(new ResponseDto("수량 변경 완료", service.UpdateCount(dto)));
	}
	
	//장바구니 삭제
	@DeleteMapping(value = "/pcart/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> delete(PdtCartDto.delete list, Principal principal){
		
		service.cartDelete(list);
		return ResponseEntity.ok(new ResponseDto("상품이 삭제되었습니다", service.listCart(principal.getName())));

	}
}

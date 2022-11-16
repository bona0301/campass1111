package com.campass.demo.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.entity.PdtCart;

@Mapper
public interface PdtCartDao {
	// 장바구니 추가 
	public Integer pAddCart(PdtCart pdtCart);
	
	// 기존 장바구니에 추가 
	public Integer cartPlus(Integer pCode, Integer pdtCartAmo, String username);
	
	// 장바구니 삭제
	public int cartDelete(String username, Integer pdtCartNo) ;
	
	// 장바구니 조회(삭제시 필요) 	
	public Optional<Integer> findByCartNo(Integer pCode);
	
	// 장바구니 리스트 
	public List<PdtCartDto.Read> listCart(String username);
	
	// 수량 플러스
	public Integer cartAmoPlusCount(Integer pCode);
	
	// 수량 마이너스
	public Integer cartAmoMinusCount(Integer pdtCartNo);
	
	// 장바구니 수량 가져오기(수량변경시 필요)
	public Optional<Integer> getCount(Integer pdtCartNo);
	
	// 동일상품 확인 
	public boolean checkCart(Integer pCode, String username); 
	
	// 장바구니 용품갯수(구매하기 저장시 필요)
	public Integer cartListSize(String username);
}

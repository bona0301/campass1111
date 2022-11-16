package com.campass.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.PdtCartDao;
import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.dto.PdtCartDto.Read;
import com.campass.demo.entity.PdtCart;

@Service
public class PCartService {
	@Autowired
	PdtCartDao cartDao;
	
	// 장바구니 추가
		public String pAddCart(PdtCartDto.pAddCart dto) {
			
			// 장바구니에 동일한상품이 있다면 새로추가 하는 게 아니라 수량을 변경한다 
			if(cartDao.checkCart(dto.getPCode(), dto.getUsername())) {
				
				// 수량변경
				cartDao.cartPlus(dto.getPCode(), dto.getPdtCartAmo(), dto.getUsername());
				return null;
			}
				// 카트추가	
				PdtCart pdtcart = dto.toEntity();
				cartDao.pAddCart(pdtcart);
				return null;
	}
		
		
	// 장바구니 정보 리스트 
		public List<PdtCartDto.Read> listCart(String username) {
			
			List<Read> cart = cartDao.listCart(username);
			
			return cart;
		}
		
	// 장바구니 삭제
		public void cartDelete(PdtCartDto.delete list) {
			for(int i = 0; i<list.getPdtCartNo().size(); i++) {
				//cartDao.cartDelete(a.).get());
				cartDao.cartDelete(list.getUsername(), list.getPdtCartNo().get(i));
			}
		}
		
		
		// 수량변경 
		public List<PdtCartDto.Read> UpdateCount(PdtCartDto.cartCountUpdate dto) {
			
			if(dto.getCountVal()) { // true 일 경우 + false 일 경우 -
				cartDao.cartAmoPlusCount(dto.getPdtCartNo());
				return cartDao.listCart(dto.getUsername());
			}
			else {
				// 1아래로 감소 불가
				if(cartDao.getCount(dto.getPdtCartNo()).get()>1) {
					cartDao.cartAmoMinusCount(dto.getPdtCartNo());
					 cartDao.listCart(dto.getUsername());
				}
				return cartDao.listCart(dto.getUsername());
			}	
		}
		
		
}

package com.campass.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.BuyListDao;
import com.campass.demo.dto.BuyListDto;

@Service
public class BuyListService {
	@Autowired
	BuyListDao dao;
	
	// 주문페이지 리스트출력
	public List<BuyListDto.BuyList> buylistGet(Integer pOdtNo, String username) {	
		return dao.buylistGet(pOdtNo, username);
	}
	
	
}

package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.campass.demo.dao.BoardDao;
import com.campass.demo.entity.Board;

@SpringBootTest
public class BoarDaoTest {

	
	@Autowired
	BoardDao dao;
	
	@Test
	public void diTest() {
		assertNotNull(dao);
	}

	//글작성
	@Test
	public void boardSaveTest() {
		Board board = Board.builder().bno(2). bTitle("제목임"). bContent("내용임").username("spring").bCateCode(0).build(); 
		
		assertEquals(1, dao.boardSave(board));
	}
} 	

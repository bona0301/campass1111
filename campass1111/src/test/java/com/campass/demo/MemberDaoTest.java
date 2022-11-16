package com.campass.demo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.time.*;
import java.util.Date;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import com.campass.demo.dao.*;
import com.campass.demo.entity.*;

import oracle.sql.*;

@SpringBootTest
public class MemberDaoTest {

	@Autowired
	BuyerDao dao;

	// @Test
	public void existsByusernameTest() {
		assertEquals(true, dao.existsBybId("젤리"));
	}

	// @Test
	public void existsByEmailTest() {
		assertEquals(true, dao.existsBybEmail("aaaa"));
	}
//아이디, 이메일, 사업자번호, 닉네임
	// @Test
	public void existsByNicknameTest() {
		assertEquals(true, dao.existsBybNickname("aaaa"));
	}

	/*@Test
	public void saveTest() {
		Buyer buyer = Buyer.builder().username("나나").bemail("yyyy").bname("name").bpassword("jkl").bname("다람쥐")
				.businessNo(22222222).build();
		assertEquals(1, dao.save(buyer));
	}*/
	
	//@Test
	public void findByusernameTest() {
		assertEquals("보라돌이", dao.findBybId("abc","강보배").get().getUsername());
		//select username from base where email='abc' and name='강보배' 
	}

	// @Test
	public void updateTest() {
		Buyer buyer= Buyer.builder().username("룰루루링").bemail("email").bname("둘리").bpassword("bbbb").build();

		assertEquals(1, dao.update(buyer));
	}

	// @Test
	public void deleteTest() {
		assertEquals(1, dao.deleteBybId("룰루루링"));

	}

	// @Test
	public void readTest() {

		assertEquals("룰루루링", dao.findBybId("aaaa", "둘리").get().getUsername()); // optional에서 꺼내면 member 에서 username 꺼야됨.
	}




	// @Test
	public void allreadTest() {
		assertEquals("aaaa", dao.read("룰루루링").get().getBemail());
		assertEquals("룰루루링", dao.read("룰루루링").get().getUsername());
		assertEquals("둘리", dao.read("룰루루링").get().getBname());
		assertEquals("bbbb", dao.read("룰루루링").get().getBpassword());

	}

}

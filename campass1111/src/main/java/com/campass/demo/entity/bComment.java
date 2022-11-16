package com.campass.demo.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class bComment {
	private Integer cno;				//댓글번호
	private String cContent;			//댓글내용
	private LocalDateTime cWrtieTime;	//댓글작성시간
	
	private Integer bno;				//글번호
	private String username;			//작성자 아이디 
	
	
	public bComment addWriter(String loginId) {
		this.username = loginId;
		return this;
	}
}


/*
  CREATE TABLE bComment (
	cno	number(10),
	bno	number(10),
	cContent	CLOB,
	cWriteTime	DATE	,
	username 	varchar2(15 char)	
);
 */
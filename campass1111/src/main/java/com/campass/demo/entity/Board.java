package com.campass.demo.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Board {

	private Integer bno;  				// 글번호
	private String bContent;			// 글내용
	private String bTitle;				// 글제목
	private LocalDateTime bWriteTime;	// 글작성시간
	private Integer readCnt; 			// 조회수
	private Integer	goodCnt;			// 좋아요
	private Integer badCnt;				// 싫어요
	private Integer commentCnt;			// 댓글수
	
	private String	username;			// 사용자 아이디
	private Integer bCateCode;			// 카데고리코드
	
	// 필드를 변경하는 애매한 의미를 가진 setter 대신 명확한 역할을 가진 메소드를 사용 
	public Board addWriter(String loginId) {
		this.username = loginId;
		return this;
	}

}
/*
  CREATE TABLE board (
 
		bno	number(10)	,
		bContent 	CLOB		,
		bTitle	varchar2(50 char)	,
		bWriteTime	DATE	,
		username	varchar2(15 char)	,
		bCateCode	varchar2(50 char)	,
		readCnt	number(10)	,
		goodCnt	number(10)	,
		badCnt	number(10)	
	);
*/
package com.campass.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.campass.demo.entity.Board;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardDto {

	@Data
	@Builder
	public static class boardSave {
		@NotEmpty(message="제목은 필수입력입니다")
		private String bTitle;
		@NotEmpty(message="내용은 필수입력입니다")
		private String bContent;
		private Integer bCateCode;
		
		public Board toEntity() {
			return Board.builder().bTitle(bTitle).bContent(bContent).bCateCode(bCateCode).build();
		}
	}
	
	@Data
	public static class boardList {
		private Integer bno;  				// 글번호
		private String bTitle;				// 글제목
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate bWriteTime;	// 글작성시간
		private Integer readCnt; 			// 조회수
		private Integer commentCnt;			// 댓글수 
		
		private String bCateName;			// 카테고리코드
		private String	username;			// 사용자 아이디
	}
	
	@Data
	@AllArgsConstructor
	public static class boardPage {
		private Integer pageno;
		private Integer pagesize;
		private Integer totalcount;
		private Collection<boardList> boardList;
	}
	
	@Data
	public static class read {
		private Integer bno;
		private String bTitle;
		private String bContent;
		private String username;
		@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
		private LocalDateTime bWriteTime;
		private Integer readCnt;
		private Integer goodCnt;
		private Integer badCnt;
		private Integer commentCnt;
		private List<CommentDto.Read> comments;
	}
	
	@Data
	@Builder
	public static class Update {
		private Integer bno;
		private String bTitle;
		private String bContent;
		
		public Board toEntity() {
			return Board.builder().bTitle(bTitle).bContent(bContent).bno(bno).build();
		}
}
}

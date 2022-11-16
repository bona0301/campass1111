package com.campass.demo.dto;

import java.time.LocalDateTime;

import javax.xml.stream.events.Comment;

import com.campass.demo.entity.bComment;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	(access=AccessLevel.PRIVATE)
public class CommentDto {
	
	@Data
	public static class  Read{
		private Integer cno;
		private String cContent;
		private String username;
		@JsonFormat(pattern="yyyy-MM-dd")
		private LocalDateTime cWriteTime;
	}

	@Data
	@Builder
	public static class Write {
		private String cContent;
		private Integer bno;
		public bComment toEntity() {
			return bComment.builder().cContent(cContent).bno(bno).build();
		}
	}
	
	@Data
	public static class delete{
		private Integer cno;
		private Integer bno;
	}
	}
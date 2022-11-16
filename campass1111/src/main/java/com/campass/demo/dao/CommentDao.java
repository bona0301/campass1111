package com.campass.demo.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.CommentDto;
import com.campass.demo.entity.bComment;

@Mapper
public interface CommentDao {
	
	// 글번호로 댓글 출력
	public List<CommentDto.Read> findByBno(Integer bno); 
	
	// 댓글 쓰기
	public Integer save(bComment comment);
	
	// 댓글 삭제
	public Integer delete(Integer cno);
	
	// 글쓴이 확인
	public Optional<String> findById(Integer cno);
	
	
	
}

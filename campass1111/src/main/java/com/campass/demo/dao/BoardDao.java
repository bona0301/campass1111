package com.campass.demo.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.BoardDto;
import com.campass.demo.entity.Board;

@Mapper
public interface BoardDao {
	
	// 글 저장 
	public Integer boardSave(Board board);
	
	// 목록페이지
	public List<BoardDto.boardList> boardList();
	
	// 개수
	public Integer count(String username);
	
	// 페이징
	public List<BoardDto.boardList> findAll(Map map);
	
	// 읽기
	public Optional<BoardDto.read> read(Integer bno);
	
	// 업데이트
	public Integer update(Board board);	
	
	// 글 변경, 삭제 전에 글쓴이를 확인 -> 글쓴이가 없다면 글이 존재하지 않는다
	public Optional<String> findWriterById(Integer bno);
	
	// 삭제
	public Integer deleteById(Integer bno);
	
	// 좋아요 개수 가져오기
	public Integer findGoodCntById(Integer bno);
		
	// 싫어요 개수 가져오기
	public Integer findBadCntById(Integer bno);
}

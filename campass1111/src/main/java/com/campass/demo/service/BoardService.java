package com.campass.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.BoardDao;
import com.campass.demo.dao.CommentDao;
import com.campass.demo.dao.MemberBoardDao;
import com.campass.demo.dto.BoardDto;
import com.campass.demo.dto.BoardDto.boardPage;
import com.campass.demo.dto.MemberBoardDto;
import com.campass.demo.entity.Board;
import com.campass.demo.exception.BoardNotFoundException;
import com.campass.demo.exception.JobFailException;

@Service
public class BoardService {
	
	@Autowired
	BoardDao dao;
	
	@Autowired
	CommentDao commentdao;
	
	@Autowired
	private MemberBoardDao memberBoardDao;
	
	 private Integer pagesize=10;
	
	// 글저장 
	public Board boardSave(BoardDto.boardSave dto, String username) {
		
		Board board = dto.toEntity();
		board.addWriter(username);
		dao.boardSave(board);
		return board;
	}
	
	// 글 페이징 
	public BoardDto.boardPage findAll(Integer pageno, String username) {
		Integer totalcount = dao.count(username);
		Integer countOfPage = (totalcount-1)/pagesize + 1;
		if(pageno>countOfPage)
			pageno=countOfPage;
		else if(pageno<0)
			pageno=-pageno;
		else if(pageno==0)
			pageno=1;
		
		Integer start = (pageno-1) * pagesize + 1;
		Integer end = start * pagesize - 1;
		
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("username",username );
		return new boardPage(pageno,pagesize,totalcount,dao.findAll(map));
	}
	
	// 글 읽기 : 글이 없으면 409(BNFE). 글이 있고 글쓴이이면 조회수 증가
	public BoardDto.read read(Integer bno, String loginId) {
		BoardDto.read dto = dao.read(bno).orElseThrow(()->new BoardNotFoundException());
			if(loginId!=null && dto.getUsername().equals(loginId)==false) {
			dao.update(Board.builder().bno(bno).readCnt(1).build());
			dto.setReadCnt(dto.getReadCnt()+1);
		}
		dto.setComments(commentdao.findByBno(bno));
		return dto;
	}
	
	// 글변경 : 실패 - 글이 없다(BoardNotFoundException), 글쓴이가 아니다(JobFailException)
	public Integer update(BoardDto.Update dto, String loginId) {
		String username = dao.findWriterById(dto.getBno()).orElseThrow(()->new BoardNotFoundException());
		if(username.equals(loginId)==false)
			throw new JobFailException("변경 권한이 없습니다");
		return dao.update(dto.toEntity());
	}
	
	// 글삭제 : 실패 - 글이 없다(BNFE), 글쓴이가 아니다(JFE)
	public Integer delete(Integer bno,  String loginId) {
		String username = dao.findWriterById(bno).orElseThrow(()->new BoardNotFoundException());
		if(username.equals(loginId)==false)
			throw new JobFailException("삭제 권한이 없습니다");
		return dao.deleteById(bno);
	}
	

	// 좋아요 또는 싫어요
	public Integer goodOrBad(MemberBoardDto dto, String loginId) {
		String writer = dao.findWriterById(dto.getBno()).orElseThrow(()->new BoardNotFoundException());
		if(writer.equals(loginId))
			throw new JobFailException("좋아요/싫어요 권한이 없습니다");
		Map<String,Object> map = new HashMap<>();
		map.put("bno", dto.getBno());
		map.put("username", loginId);
		if(memberBoardDao.existsById(map)==true) {
			if(dto.getIsGood()==true)
				return dao.findGoodCntById(dto.getBno());
			return dao.findBadCntById(dto.getBno());
		} else {
			memberBoardDao.save(map);
			if(dto.getIsGood()==true) {
				dao.update(Board.builder().bno(dto.getBno()).goodCnt(1).build());
				return dao.findGoodCntById(dto.getBno());
			}
			dao.update(Board.builder().bno(dto.getBno()).badCnt(1).build());
			return dao.findBadCntById(dto.getBno());
		}
	}
}

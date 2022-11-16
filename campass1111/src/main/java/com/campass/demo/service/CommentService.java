package com.campass.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.BoardDao;
import com.campass.demo.dao.CommentDao;
import com.campass.demo.dto.CommentDto;
import com.campass.demo.entity.Board;
import com.campass.demo.exception.CommentNotFoundException;
import com.campass.demo.exception.JobFailException;

@Service
public class CommentService {

		@Autowired
		private CommentDao commentdao;
		
		@Autowired
		private BoardDao boarddao;
		
		// 댓글쓰기
		public List<CommentDto.Read> write(CommentDto.Write dto, String loginId) {
			commentdao.save(dto.toEntity().addWriter(loginId));
			boarddao.update(Board.builder().bno(dto.getBno()).commentCnt(1).build());
			return commentdao.findByBno(dto.getBno());
		}
		
		//댓글 삭제 
		public List<CommentDto.Read> delete(CommentDto.delete dto, String loginId) {
			String writer = commentdao.findById(dto.getCno()).orElseThrow(CommentNotFoundException::new);
			if(!writer.equals(loginId))
				throw new JobFailException("삭제할 수 없습니다");
			commentdao.delete(dto.getCno());
			return commentdao.findByBno(dto.getBno());
		}

}

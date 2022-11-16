package com.campass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/buyer")
public class BuyerBoardViewController {
	// 게시판 리스트
	  	@GetMapping("/board/list")
		public ModelAndView boardlist() {
	  		return new ModelAndView("/buyer/board/list");
		}
	  	
	  	// 게시판 작성
		@GetMapping("/board/write")
		public ModelAndView  boardWrite() {
			return new ModelAndView("/buyer/board/write");
		}
		
		
		// 게시판 읽기
		@GetMapping("/board/read")
		public ModelAndView  boardRead() {
			return new ModelAndView("/buyer/board/read");
		}
		
	    // 게시판 글수정
	    @GetMapping("/board/update")
	    public ModelAndView  boardUpdate() {
	       return new ModelAndView("/buyer/board/update");
	    }
}

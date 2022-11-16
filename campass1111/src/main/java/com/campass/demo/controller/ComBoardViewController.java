package com.campass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/com")
public class ComBoardViewController {
	
	// 게시판 리스트
  	@GetMapping("/board/list")
	public ModelAndView boardlist() {
  		return new ModelAndView("/com/board/list");
	}
	  	
  	// 게시판 읽기
 	@GetMapping("/board/read")
 	public ModelAndView  boardRead() {
 		return new ModelAndView("/com/board/read");
 	}
}

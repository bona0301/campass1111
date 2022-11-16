package com.campass.demo.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.BoardDto;
import com.campass.demo.dto.RestResponse;
import com.campass.demo.entity.Board;
import com.campass.demo.service.BoardService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="/buyer")
public class BuyerBoardController {

	@Autowired
	private BoardService service;
	 
	//  글저장
	@PostMapping(value = "/board/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> boardSave(BoardDto.boardSave dto, Principal principal){
		Board board = service.boardSave(dto, principal.getName());
		return ResponseEntity.ok(new RestResponse("OK", board, "/board/read?bno=" + board.getBno()));
	}
	
	// 리스트 
	@GetMapping(value="/board/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> findAll(@RequestParam(defaultValue = "1") Integer pageno, String username) {
		return ResponseEntity.ok(new RestResponse("OK", service.findAll(pageno, username), null ));
	}
	
	// 글읽기
	@GetMapping(value="/board/read/rest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> read(@RequestParam Integer bno, @ApiIgnore Principal principal) {
		BoardDto.read dto = service.read(bno, principal.getName());
		return ResponseEntity.ok(new RestResponse("OK", dto, null));
	}
	
	   
	// 글변경
	@PutMapping(value="/board/modify", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> update(@ModelAttribute BoardDto.Update dto,  @ApiIgnore Principal principal) {
	   service.update(dto, principal.getName());
	   return ResponseEntity.ok(new RestResponse("OK", dto.getBno() + "글을 변경했습니다", "/buyer/board/read?bno="+dto.getBno()));
	}
	   
	// 글삭제
	@DeleteMapping(value="/board/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> delete(@RequestParam Integer bno, @ApiIgnore Principal principal) {
	   service.delete(bno, principal.getName());
	   return ResponseEntity.ok(new RestResponse("OK", bno +"번 글을 삭제했습니다", "/buyer/board/list"));
	}
}

package com.campass.demo.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.BoardDto;
import com.campass.demo.dto.RestResponse;
import com.campass.demo.service.BoardService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="/com")
public class ComBoardController {

	@Autowired
	private BoardService service;
	 	
	// 리스트 
	@GetMapping(value="/board/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> findAll(@RequestParam(defaultValue = "1") Integer pageno, String username) {
		return ResponseEntity.ok(new RestResponse("OK", service.findAll(pageno, username), null));
	}
	
	// 글읽기
	@GetMapping(value="/board/read/rest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> read(@RequestParam Integer bno, @ApiIgnore Principal principal) {
		BoardDto.read dto = service.read(bno, principal.getName());
		return ResponseEntity.ok(new RestResponse("OK", dto, null));
	}
}

package com.campass.demo.controller;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.CommentDto;
import com.campass.demo.dto.RestResponse;
import com.campass.demo.service.CommentService;

@RestController
@RequestMapping(value="/buyer")
public class BuyerCommentController {
	
	@Autowired
	private CommentService service;
	
	@PostMapping(value="/comments/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> write(@ModelAttribute CommentDto.Write dto, Principal principal) {
		List<CommentDto.Read> list = service.write(dto, principal.getName());
		return ResponseEntity.ok(new RestResponse("OK", list, null));
	}
	
	@DeleteMapping(value="/comments/delete", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> delete(@ModelAttribute CommentDto.delete dto, Principal principal){
		List<CommentDto.Read> list = service.delete(dto, principal.getName());
		return ResponseEntity.ok(new RestResponse("OK", list, null));
	}
}

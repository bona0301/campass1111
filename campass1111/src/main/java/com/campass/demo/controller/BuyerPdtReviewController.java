package com.campass.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.PdtReviewDto;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.PdtReviewService;

@RestController
@RequestMapping(value="/buyer")
public class BuyerPdtReviewController {
   @Autowired
   PdtReviewService service;
   
   @PostMapping(value="/product/detail/review/save", produces=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ResponseDto> save(PdtReviewDto.SaveReview dto, Principal principal) {
	   System.out.println(dto);
	   service.saveReview(dto);
      return ResponseEntity.ok(new ResponseDto("한줄평 작성이 완료되었습니다", principal.getName()));
   }
 
}


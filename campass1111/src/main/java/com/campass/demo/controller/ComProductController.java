package com.campass.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.ProductDto;
import com.campass.demo.dto.ProductDto.ReadCategoryList;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.ProductService;

@RestController
@RequestMapping(value="/com")
public class ComProductController {
   @Autowired
   private ProductService service;
   
   // 카테고리
   @GetMapping(value="/product/category", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<ReadCategoryList>> ReadCateList(String pCateCode){
      return ResponseEntity.ok(service.ReadCateList(pCateCode));

   }
   
   // 글목록 출력
   @GetMapping(value = "/product/list", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ProductDto.ProductPaging> findAll(@RequestParam(defaultValue = "1") Integer pageno, Integer pCode) {
      System.out.println("==========================");
      System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
      System.out.println(service.findAll(pageno, null));
      
      return ResponseEntity.ok(service.findAll(pageno, null));
   }
   
   // 글 상세
   @GetMapping(value="/product/detail", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ProductDto.PdtDetailWithReadReviewList> detail(Integer pCode){
      return ResponseEntity.ok(service.detail(pCode));

   }
   
   // 평점 평균
   @PutMapping(value="/product/pStarAvg", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ProductDto.UpdateStar> setRating(Integer pCode){
	   return ResponseEntity.ok(service.setRating(pCode));
   }

   // 한줄평(in상세) 출력
   @GetMapping(value="/product/detail/review", produces=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ResponseDto> read(Integer pCode){
      return ResponseEntity.ok(new ResponseDto("상세페이지의 용품 리뷰 출력" ,service.reviewList(pCode)));
   }
}


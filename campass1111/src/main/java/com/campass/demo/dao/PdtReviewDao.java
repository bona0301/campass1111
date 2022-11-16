package com.campass.demo.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.PdtReviewDto;

@Mapper
public interface PdtReviewDao {

	
   // 댓글 등록
   public Integer saveReview(PdtReviewDto.SaveReview dto);
   
   

}
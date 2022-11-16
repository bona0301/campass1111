package com.campass.demo.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.ProductDto;

@Mapper
public interface ProductDao {
   // 카테고리 리스트 읽어오기
   public List<ProductDto.ReadCategoryList> ReadCateList(String pCateCode);
   
   // 목록페이지
   public List<ProductDto.ForProductList> productList();
   
   // 용품 개수
   public Integer countProduct(Integer pCode);
    
   // 페이징
   public List<ProductDto.ForProductList> findAll(Map map);                                          
   
   // 상세페이지 
   public Optional<ProductDto.PdtDetail> productDetail(Integer pCode);
   
   // 별점 평균 구하기
   public Double getStarAvg(Integer pCode);
   
   // 별점 평균 반영
   public Integer updateStarAvg(ProductDto.UpdateStar dto);
   
   // 한줄평 개수
   public Integer countReview(Integer pReviewNo);
   
   // 한줄평 목록
   public List<ProductDto.ReadReviewList> reviewList(Integer pCode);
            
   
}
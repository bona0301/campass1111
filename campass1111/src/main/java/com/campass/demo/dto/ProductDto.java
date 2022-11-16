package com.campass.demo.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class ProductDto {
   @Data
   public static class ReadCategoryList{
	  private Integer pCode;
	  private String pName;
	  private String pMainImg;
	  private Integer pPrice;
      private String pCateCode;
      private String pCateName;
   }
   
   // 목록
   @Data
   public static class ForProductList {
      private Integer pCode;
      private String pName;
      private String pMainImg;
      private Integer pPrice;
      private String pCateCode;  
   }
   
   // 목록 페이징
   @Data
   @AllArgsConstructor
   public static class ProductPaging {
      private Integer pageno;
      private Integer pagesize;
      private Integer totalcount;
      private Collection<ForProductList> productList;
   }

   
   // 용품 상세페이지   
   @Data
   @Builder
   public static class PdtDetail {
      private Integer pCode;
      private String pName;
      private String pMainImg;
      private String pContentImg;
      private String pBrand;
      private Double pStarAvg;
      private Integer pPrice;
      
      
	public void addAvgStar(Double starAvg) {
		this.pStarAvg = starAvg;
	}
   }
   
   // 리뷰 리스트
   @Data
   public static class ReadReviewList{
      private Integer previewNo;
	  private Integer pCode;
      private Integer pStar;
      private String pReviewContent;
      private String username;
      @JsonFormat(pattern="yyyy-MM-dd")
      private LocalDate pReviewDate;
   }
   
   @Data
   public static class PdtDetailWithReadReviewList {
	   private PdtDetail pdtDetail;
	   private List<ReadReviewList> readReviewLists;
	
   }
   
   @Data
   public static class UpdateStar{
	   private Integer pCode;
	   private Double pStarAvg;
   }
}
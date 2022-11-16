package com.campass.demo.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PdtReview {
   private Integer pReviewNo;
   private Integer pStar;
   private String pReviewContent;
   private String username;
   private LocalDate pReviewDate;
   private Integer pOdtNo;
   private Integer pOrderNo;
   private Integer pCode;
   private String shipName;

   public PdtReview addWriter(String username) {
      this.username = username;
      return this;
   }

}
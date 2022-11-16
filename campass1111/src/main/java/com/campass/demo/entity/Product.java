package com.campass.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
   private Integer pCode;
   private String pName;
   private String pMainImg; 
   private String pContentImg;
   private String pBrand;
   private Double pStarAvg;
   private Integer pPrice;
   private String pCateCode;
}
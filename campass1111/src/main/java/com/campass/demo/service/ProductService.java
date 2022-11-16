package com.campass.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.ProductDao;
import com.campass.demo.dto.ProductDto;
import com.campass.demo.dto.ProductDto.ProductPaging;

@Service
public class ProductService {
   @Autowired
   private ProductDao dao;
//   @Value("${campass.pagesize}")
   private Integer pagesize=16;
   
   // 카테고리 리스트
   public List<ProductDto.ReadCategoryList> ReadCateList(String pCateCode){
	   return dao.ReadCateList(pCateCode);
   }
   
   // 용품 리스트 출력
   public List<ProductDto.ForProductList> list(){
      return dao.productList();   
   }
   
   // 용품 페이징  
   public ProductDto.ProductPaging findAll(Integer pageno, Integer pCode) {
      Integer totalcount = dao.countProduct(pCode);
      Integer countOfPage = (totalcount-1)/pagesize + 1;
      
      if(pageno>countOfPage)
         pageno=countOfPage;
      else if(pageno<0)
         pageno=-pageno;
      else if(pageno==0)
         pageno=1;
      
      Integer start = (pageno-1) * pagesize + 1;
      Integer end = pageno * pagesize;
      
      Map<String,Object> map = new HashMap<>();
      map.put("start", start);
      map.put("end", end);
      map.put("pCode", pCode);
      return new ProductPaging(pageno,pagesize,totalcount,dao.findAll(map));
   }
   
   // 용품 상세페이지 출력
   public ProductDto.PdtDetailWithReadReviewList detail(Integer pCode){
	  ProductDto.PdtDetailWithReadReviewList dto = new ProductDto.PdtDetailWithReadReviewList(); 
	  ProductDto.PdtDetail value = dao.productDetail(pCode).get();
	  value.addAvgStar(dao.getStarAvg(pCode));
	  dto.setPdtDetail(value);
	  dto.setReadReviewLists(dao.reviewList(pCode));
      return dto;
   }
   
   // 별점 평균
   public ProductDto.UpdateStar setRating(Integer pCode) {
	   Double starAvg = dao.getStarAvg(pCode);
	 
	   ProductDto.UpdateStar dto = new ProductDto.UpdateStar();
	   dto.setPCode(dao.countReview(pCode));
	   dto.setPStarAvg(dao.getStarAvg(pCode));
	   
	   setRating(dto.getPCode());
	   
	   dao.updateStarAvg(dto);
	return dto;
   }
   
   // 상세페이지 안에 있는 한줄평 출력
   public List<ProductDto.ReadReviewList> reviewList(Integer pCode){
      return dao.reviewList(pCode);
   }
}
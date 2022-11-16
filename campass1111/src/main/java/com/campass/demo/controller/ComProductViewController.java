package com.campass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComProductViewController {
   // 용품 메인
   @GetMapping("/com/product")
   public ModelAndView list() {
      return new ModelAndView("/com/product/product");
   }

   // 용품 메인 카테(텐트) 
   @GetMapping("/com/product/sort1") 
   public ModelAndView tent() { 
	  return new ModelAndView("/com/product/productSort1"); 
   }
	  
   // 용품 메인 카테(매트)
   @GetMapping("/com/product/sort2") 
   public ModelAndView mat() { 
	   return new ModelAndView("/com/product/productSort2"); 
   }

   // 용품 메인 카테(테이블)
   @GetMapping("/com/product/sort3") 
   public ModelAndView table() { 
	   return new ModelAndView("/com/product/productSort3"); 
   }

   // 용품 메인 카테(식기)
   @GetMapping("/com/product/sort4") 
   public ModelAndView dish() { 
	   return new ModelAndView("/com/product/productSort4"); 
   }

   // 용품 메인 카테(기타)
   @GetMapping("/com/product/sort5") 
   public ModelAndView etc() { 
	   return new ModelAndView("/com/product/productSort5"); 
   }
   
   // 용품 상세
   @GetMapping("/com/product/product_detail")
   public ModelAndView read() {
	   return new ModelAndView("/com/product/product_detail"); 
   }
  	
}
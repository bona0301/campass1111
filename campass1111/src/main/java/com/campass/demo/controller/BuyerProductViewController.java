package com.campass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyerProductViewController {
   // 용품 메인
   @GetMapping("/buyer/product")
   public ModelAndView list() {
      return new ModelAndView("/buyer/product/product");
   }

   // 용품 메인 카테(텐트) 
   @GetMapping("/buyer/product/sort1") 
   public ModelAndView tent() { 
	  return new ModelAndView("/buyer/product/productSort1"); 
   }
	  
   // 용품 메인 카테(매트)
   @GetMapping("/buyer/product/sort2") 
   public ModelAndView mat() { 
	   return new ModelAndView("/buyer/product/productSort2"); 
   }

   // 용품 메인 카테(테이블)
   @GetMapping("/buyer/product/sort3") 
   public ModelAndView table() { 
	   return new ModelAndView("/buyer/product/productSort3"); 
   }

   // 용품 메인 카테(식기)
   @GetMapping("/buyer/product/sort4") 
   public ModelAndView dish() { 
	   return new ModelAndView("/buyer/product/productSort4"); 
   }

   // 용품 메인 카테(기타)
   @GetMapping("/buyer/product/sort5") 
   public ModelAndView etc() { 
	   return new ModelAndView("/buyer/product/productSort5"); 
   }
   
   // 용품 상세
   @GetMapping("/buyer/product/product_detail")
   public ModelAndView read() {
	   return new ModelAndView("/buyer/product/product_detail");
   }

   // 용품 장바구니
   @GetMapping("/buyer/product/pcart")
   public ModelAndView listCart() {
      return new ModelAndView("/buyer/product/pcart");
   }
   
   // 용품 주문
   @GetMapping("/buyer/product/porder")
   public ModelAndView orderlist() {
       return new ModelAndView("/buyer/product/porder");
   }
   
   // 주문내역 출력
   @GetMapping("/buyer/product/order/buylist")
   public ModelAndView buylist() {
       return new ModelAndView("/buyer/product/buylist");
   }
   
   // 용품 주문완료.
  	@GetMapping("/buyer/product/porderfin")
	public ModelAndView orderfin() {
  		return new ModelAndView("/buyer/product/porderfin");
  	}
  	
}
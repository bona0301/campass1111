package com.campass.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.BuyListDao;
import com.campass.demo.dao.PdtReviewDao;
import com.campass.demo.dao.ProductDao;
import com.campass.demo.dto.PdtReviewDto;

@Service
public class PdtReviewService {
   @Autowired
   PdtReviewDao rdao;
   @Autowired
   ProductDao pdao;
   @Autowired
   BuyListDao bdao;
   @Autowired
   ProductService service;
   
   public PdtReviewDto.SaveReview saveReview(PdtReviewDto.SaveReview dto) {
//	      PdtReview pdtReview = dto.toEntity();
//
//	      pdtReview.addWriter("spring");
	      rdao.saveReview(dto);
	      bdao.updateStatus(dto.getPOdtNo());
	      

	      return dto;
	   }



//   public List<PdtReviewDto.ReadReviewList> write(PdtReviewDto.SaveReview dto, String loginId){
//      dao.saveReview(dto.toEntity().addWriter(loginId));
//      return dao.findById(dto.getPOdtNo());
//   }

//   @Transactional
//   public List<PdtReviewDto.ReadReviewList> delete (PdtReviewDto.DeleteReview dto, String loginId){
//      String bId = dao.findById(dto.getPReviewNo()).orElseThrow(PdtReviewNotFoundException::new);
//      if(!bId.equals(loginId))
//         throw new JobFailException("삭제할 수 없습니다");
//      dao.deletePdtReview(dto.getPCode());
//      return dao.findByPCode(d)
//   }

}
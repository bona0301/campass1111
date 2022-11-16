package com.campass.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.campass.demo.dao.CZoneDao;
import com.campass.demo.dto.CZoneDto;
import com.campass.demo.dto.CampingDto;
import com.campass.demo.dto.CZoneDto.CZUpdateDto;
import com.campass.demo.entity.CZone;
import com.campass.demo.entity.Camping;
import com.campass.demo.exception.BoardNotFoundException;
import com.campass.demo.exception.JobFailException;




@Service
public class CZoneService {
	
@Autowired
private CZoneDao cZoneDao;


// 일단 변수 선언 해주는데 파라미터값으로 넣어야할지도?  세션정보 받아와야되는데 session.getattribute 가 안먹혀서 가져왔다 가져오니까 된다 올ㅋ
//근데 로그인아이디는 principal 객체써도되는것같다 둘다 이용해보기로함 
HttpSession session;
HttpServletRequest request;

@Value("c:/upload")
private String imageFolder;

@Value("http://localhost:8087/images/")
private String imagePath;







	public CZone cZoneWrite(CZoneDto.CZWriteDto dto, String loginId,Integer cCode) {
		
		CZone cZone = dto.toCZentity().czAdd(loginId,cCode);
		MultipartFile photo = dto.getCzPhoto();
		if(photo!=null& photo.isEmpty()==false) {
			// 업로드한 MultipartFile을 c:/upload에 이동하자  
			File file = new File(imageFolder, photo.getOriginalFilename());
			try {
				photo.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			cZone.setCzPhoto(imagePath + photo.getOriginalFilename()); 
		}
		System.out.println(cZone);
		
		cZoneDao.cZoneSave(cZone);
		return cZone;
	}
	

	
	
	public Integer czoneUpdate(CZoneDto.CZUpdateDto dto, String loginId, Integer cCode,Integer czCode) {
		
		String writer = cZoneDao.czFindWriterById(dto.getCzCode()).orElseThrow(()->new BoardNotFoundException());
		if(writer.equals(loginId)==false)
			throw new JobFailException("변경 권한이 없습니다");
		
		
		return cZoneDao.cZoneUpdate(dto);
	}
	
	public Integer czDelete(Integer czCode, String loginId) {
		String writer = cZoneDao.czFindWriterById(czCode).orElseThrow(()->new BoardNotFoundException());
		if(writer.equals(loginId)==false)
			throw new JobFailException("삭제 권한이 없습니다");
		return cZoneDao.cZoneDel(czCode);
		
		
	}
	

}





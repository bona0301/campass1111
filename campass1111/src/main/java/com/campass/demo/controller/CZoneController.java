package com.campass.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.campass.demo.dto.CZoneDto;
import com.campass.demo.dto.CampingDto;
import com.campass.demo.dto.CZoneDto.CZUpdateDto;
import com.campass.demo.dto.CampingDto.CUpdateDto;
import com.campass.demo.entity.CZone;
import com.campass.demo.entity.Camping;
import com.campass.demo.service.CZoneService;
import com.campass.demo.service.CampingService;

@Controller
@RequestMapping(value="/seller")
public class CZoneController {
	@Autowired (required=true)
	private CZoneService czoneService;
	@Autowired (required=true)
	private CampingService campingService;
	HttpSession session;
	HttpServletRequest request;
	// 개발용 가짜 아이디. 로그인을 붙이고 나면 지우고 principal로 변경
	@Value("Spring")
	private String usernameForDevelopement;
	
	@Value("c:/upload")
	private String imageFolder;

	
	// mvc : model, view
	/*
	public ModelAndView aaa() {
		return new ModelAndView("aaa").addObject("list", null);
	}
	
	public String aaa(Model model) {
		model.addAttribute("list", null);
		return "aaa";
	}
	*/
	


	@GetMapping("/czAdd")
	public String cZoneAdd(Model model,Integer cCode){
		model.addAttribute("czAdd", cCode);
		return "/cZone/write";
	
	}
	
	@PostMapping("/czAdd")
	public String cZoneAdd( CZoneDto.CZWriteDto dto,Model model,Principal principal, Integer cCode){
		
			CZone czoneModel = czoneService.cZoneWrite(dto, usernameForDevelopement,cCode);
			model.addAttribute(czoneModel);
		return "redirect:/seller/campingRead?cCode="+czoneModel.getCz_cCode();
	
	}
	
	//======update 부터 delete 까지헷갈림
	
	@RequestMapping(value="/czoneUpdate", method=RequestMethod.GET)
	public String czUpdateView(Integer cCode, Integer czCode, Model model,Principal principal) {
		model.addAttribute("update", campingService.campingRead(cCode, usernameForDevelopement));
		model.addAttribute("cCode", cCode);
		model.addAttribute("czCode",czCode);
		return "czone/update";
	}
	
	
	@RequestMapping(value="/czoneUpdate", method=RequestMethod.POST)
	public String czUpdate(CZUpdateDto dto,Model model, Principal principal,Integer cCode,Integer czCode) {
		
		czoneService.czoneUpdate(dto, usernameForDevelopement,cCode,czCode);
		return "redirect:/seller/campingRead?cCode=" + cCode;
	}
	
	
	
	@DeleteMapping("/czDelete")
	public String Delete(Integer czCode, Principal principal,Integer cCode) {
		
		Integer cZoneDelete =  czoneService.czDelete(czCode, usernameForDevelopement);
		
		return "redirect:/seller/campingRead?cCode=" + cCode;
	}
}

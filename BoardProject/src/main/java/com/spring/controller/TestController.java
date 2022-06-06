package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.mapper.TestMappers;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final TestMappers mapper;
	
	@GetMapping("/index")
	public void index(Model model) {
		
		int result = mapper.selectTest();
		model.addAttribute("result", result);
	}
}

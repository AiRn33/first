package com.bok.contorller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bok.domain.BoardVO;
import com.bok.domain.UserVO;
import com.bok.service.BoardService;
import com.bok.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
	private final BoardService service;
	private final UserService uservice;
	
	@GetMapping("/register")
	public void getregister(HttpSession session) {
		System.out.println("GetRegister Start");
		System.out.println("userNumber : " + session.getAttribute("userNumber"));
	}
	
	@PostMapping("/register")
	public String postregister(BoardVO vo,RedirectAttributes rttr) {
		
		System.out.println("PostRegister Start");
		
		service.register(vo);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void getlist(HttpSession session,Model model) {
		System.out.println("getList Start");
		
		List<BoardVO> list= service.list((int)session.getAttribute("userNumber"));
		
		model.addAttribute("list",list);
		
	}
	
	@GetMapping("/get")
	public void getget(@RequestParam("boardNumber") int boardNumber,
						HttpSession session, Model model) {
		
		System.out.println("getGet Start");
		
		UserVO uvo = uservice.userGet((int)session.getAttribute("userNumber"));
		BoardVO bvo = service.get(boardNumber);
		
		model.addAttribute("uvo",uvo);
		model.addAttribute("bvo",bvo);
	}
	
	@GetMapping("/modify")
	public void getmodify(@RequestParam("boardNumber") int boardNumber,
							Model model) {
		System.out.println("getModify Start");
		
		BoardVO vo = service.get(boardNumber);
		model.addAttribute("vo",vo);
	}

	@PostMapping("/modify")
	public String postmodify(BoardVO vo) {
		
		System.out.println("postModify Start");
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		
		service.modify(vo);
		BoardVO bvo = service.get(vo.getBoardNumber());
		
		return "redirect:/board/get?boardNumber="+bvo.getBoardNumber();
	}
	
	@GetMapping("/remove")
	public String getremove(@RequestParam("boardNumber") int boardNumber) {
		
		System.out.println("getremove Start");
		
		BoardVO vo = service.get(boardNumber);
		service.remove(boardNumber);
		
		return "redirect:/board/list?userNumber="+vo.getUserNumber();
	}
	
}
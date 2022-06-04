package com.bok.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bok.domain.BoardVO;
import com.bok.domain.UserVO;
import com.bok.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {

	private final UserService service;
	
	@GetMapping("/login")
	public String getlogin() {
		
		System.out.println("GetLogin Start");
		
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, UserVO vo, Model model) {
		
		int userNumber;
		try {
			userNumber = service.login(vo);
		}catch(Exception e)
		{
			userNumber = 0;
		}
		
		System.out.println("PostLogin Start");
		
		if(userNumber >= 1) {
			
			session.setAttribute("userNumber", userNumber);
			List<BoardVO> list = service.boardCheck(userNumber);
			model.addAttribute("list",list);
			
			return "redirect:/board/list";
		}else{
			
			model.addAttribute("check",false);
			
			return "/user/login";
		}
	}
	
	@GetMapping("/joinMember")
	public void joinMember() {
		System.out.println("GetJoinMember Start");
	}
	
	@PostMapping("/joinMember")
	public String PostjoinMember(UserVO vo) {
		
		System.out.println("PostJoinMember Start");
		service.joinMember(vo);
		
		return "/user/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck")
	public int idCheck(@RequestParam("id") String id,Model model) {
	
		System.out.println("idCheck Start");

		UserVO vo = new UserVO();
		vo.setId(id);
		
		int num = service.idcheck(vo);
		
		return num;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		
		System.out.println("logout Start");
		        
        HttpSession session = request.getSession();
        
        session.invalidate();
        request.getSession(true);
        
        return "redirect:/user/login"; 
	}
}

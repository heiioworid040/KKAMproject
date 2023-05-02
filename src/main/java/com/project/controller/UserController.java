package com.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.domain.UserDTO;
import com.project.myweb.UserService;

@Controller
public class UserController {
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		
		return "main";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value = "/user/loginPro", method = RequestMethod.POST)
	public String loginPro(HttpServletRequest request, HttpSession session, Model model) {
		UserDTO userDTO=new UserDTO();
		userDTO.setU_id(request.getParameter("id"));
		userDTO.setU_pw(request.getParameter("pw"));
		
		UserDTO checkDTO = userService.userCheck(userDTO);
		if(checkDTO!=null) {
			session.setAttribute("id", userDTO.getU_id());
			return "redirect:/main";
		}else {
			String result="null";
			model.addAttribute("result", result);
			return "user/login";
		}
	}
	
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}
	
	@RequestMapping(value = "/user/join", method = RequestMethod.GET)
	public String join(HttpSession session) {
		
		return "redirect:/user/join";
	}
}











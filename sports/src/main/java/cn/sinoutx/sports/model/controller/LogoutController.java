package cn.sinoutx.sports.model.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping
	public String logout(HttpSession session){
		if(session == null){
		return "redirect:/login";
		}
		session.removeAttribute("user");
		return "redirect:/sport";
		
	}
}

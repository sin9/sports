package cn.sinoutx.sports.model.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.dao.UserDao;
import cn.sinoutx.sports.model.entity.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	public UserDao usd;
	
	@RequestMapping
	private void index() {
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String post(String username,String password,Model model,HttpSession Session){
		List<User> us = usd.findByUname(username);
		
		User u = new User();
	
	if(username!=""&&password!=""&& !us.isEmpty()){
		boolean s = false;
		for (User user : us) {
		s =user.getPassword().equals(password);
		if(s==true){
			u = user;
			break;
		}
		}
	if (s){
		Session.setAttribute("user", u);
		return "redirect:/sport";
	}
	
    else{
    	model.addAttribute("error", "用户名或密码错误！");

    	return null;
    }
	
	}
	else{
		model.addAttribute("error", "用户名或密码错误");
		return null;
	}

		
	
}
}

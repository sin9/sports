package cn.sinoutx.sports.model.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.entity.User;
import cn.sinoutx.sports.model.services.UserService;

@Controller
@RequestMapping("/changepassword")
public class ChangepasswordController {
	@Autowired
	public UserService us;
	
	@RequestMapping
	private void index() {
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(method=RequestMethod.POST)
	private String updatePassword(String nowpassword,String nowagainpassword,String newpassword,Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(nowpassword.equals(nowagainpassword)) {
			int a = us.updatePassword(newpassword, user.getUid());
		
		if(a>0) {
			return "redirect:/logout";
		}else {
			model.addAttribute("error", "操作失败");
			return "redirect:/changepassword";
		}
		}else {
			model.addAttribute("error", "两次输入原密码必须一致");
			return "redirect:/changepassword";
		}
		
	}

}

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
@RequestMapping("/userinformation")
public class UserinformationController {
	@Autowired
	public UserService us;
	@RequestMapping
	private void index() {
		

	}

	@RequestMapping(method=RequestMethod.POST)
	private String update(String uname,String gender,String email,String address,String tel,Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(email==null) {
			email = " ";
		}
		if(address==null) {
			address = " ";
		}
		if(tel == null) {
			tel = " ";
		}
		int a = us.update(uname, gender, email, address, tel, user.getUid());
		if(a>0 && uname!=null) {
			return "redirect:/sport";
		}else {
			model.addAttribute("error", "操作失败");
			return "redirect:/userinformation";
		}
		
	}
}

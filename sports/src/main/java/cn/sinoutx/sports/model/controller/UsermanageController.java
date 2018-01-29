package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.UserDao;
import cn.sinoutx.sports.model.entity.User;

@Controller
@RequestMapping("/usermanage")
public class UsermanageController {
	
	@Autowired
	public UserDao ud;
	
	@RequestMapping
	private void index(Model model) {
	Iterable<User>	users = ud.findAll();
	model.addAttribute("users", users);

	}

}

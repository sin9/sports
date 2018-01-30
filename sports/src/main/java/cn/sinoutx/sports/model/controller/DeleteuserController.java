package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.UserDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqtype;
import cn.sinoutx.sports.model.entity.User;
import cn.sinoutx.sports.model.services.UserService;

@Controller
@RequestMapping("/deleteuser")
public class DeleteuserController {

	@Autowired
	public UserDao ud;
	@Autowired
	public UserService us;
	@RequestMapping(value = "/deleteuser/{id}")
	public String editeq(@PathVariable Integer id,Model model) {
	
	User user = ud.findOne(id);
	if(user!=null) {
	
		us.delete(id);
		return "redirect:/usermanage";
	}else {
		model.addAttribute("error", "操作失败");
		return "redirect:/usermanage";
	}

	}
	
}

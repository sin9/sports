package cn.sinoutx.sports.model.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.dao.OutlogDao;
import cn.sinoutx.sports.model.entity.Outlog;
import cn.sinoutx.sports.model.entity.User;
import cn.sinoutx.sports.model.services.EquipmentService;

@Controller
@RequestMapping("/returnall")
public class ReturnallController {
	@Autowired
	public OutlogDao otd;
	
	@Autowired
	public EquipmentService eqs;
	
	@RequestMapping
	private void index(Model model) {
		
		Iterable<Outlog> outlogs = otd.findAll();
		
		model.addAttribute("outlogs", outlogs);

	}
	
	@RequestMapping(method=RequestMethod.POST)
	private String add(Integer outlog,Integer number,String retname,String des,Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		 System.out.println(">>>>>>>>>>" +outlog+"sssssssss"+number+"oooooooo"+retname);
		int a = eqs.addReturnlogand(outlog, number, retname, des, user);
		if(a>0) {
			model.addAttribute("error", "操作成功");
			return "redirect:/returnall";
		}else {
			model.addAttribute("error", "操作失败");
			return "redirect:/returnall";
		}
		
	}
}

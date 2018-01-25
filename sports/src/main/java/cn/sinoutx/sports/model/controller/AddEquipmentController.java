package cn.sinoutx.sports.model.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.User;
import cn.sinoutx.sports.model.services.EquipmentService;

@Controller
@RequestMapping("/addequipment")
public class AddEquipmentController {

	@Autowired
	public EqnameDao end;
	
	@Autowired
	public EquipmentService eqs;
	
	@RequestMapping
	private void index(Model model) {
		Iterable<Eqname> eqnames = end.findAll();
		model.addAttribute("eqnames", eqnames);
		

	}
	
	@RequestMapping(method=RequestMethod.POST)
	private String add(Integer eqnid,Integer number,Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		int a = eqs.add(eqnid, number, user);
		if(a>0) {
			return "redirect:/allequipment";
		}else {
			model.addAttribute("error", "操作失败");
			return "redirect:/addequipment";
		}
		
	}
}

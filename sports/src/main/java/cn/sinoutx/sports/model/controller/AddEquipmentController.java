package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.entity.Eqname;

@Controller
@RequestMapping("/addequipment")
public class AddEquipmentController {

	@Autowired
	public EqnameDao end;
	
	@RequestMapping
	private void index(Model model) {
		Iterable<Eqname> eqnames = end.findAll();
		model.addAttribute("eqnames", eqnames);
		

	}
	
	@RequestMapping(method=RequestMethod.POST)
	private String add(String modules,Integer number,Model model) {
		
		return "redirect:/addequipment";
	}
}

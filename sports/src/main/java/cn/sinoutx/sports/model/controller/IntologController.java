package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.IntologDao;
import cn.sinoutx.sports.model.entity.Intolog;

@Controller
@RequestMapping("/intolog")
public class IntologController {
	
	@Autowired
	public IntologDao ind;

	@RequestMapping
	private void index(Model model) {
		
		Iterable<Intolog> intologs = ind.findAll();
		model.addAttribute("intologs", intologs);

	}
}

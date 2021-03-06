package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.IntologDao;
import cn.sinoutx.sports.model.dao.OutlogDao;
import cn.sinoutx.sports.model.entity.Intolog;
import cn.sinoutx.sports.model.entity.Outlog;

@Controller
@RequestMapping("/outlog")
public class OutlogController {
	
	@Autowired
	public OutlogDao old;

	@RequestMapping
	private void index(Model model) {
		
		Iterable<Outlog> outlogs = old.findAll();
		model.addAttribute("outlogs", outlogs);

	}
}

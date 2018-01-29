package cn.sinoutx.sports.model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.IntologDao;
import cn.sinoutx.sports.model.dao.OutlogDao;
import cn.sinoutx.sports.model.entity.Intolog;
import cn.sinoutx.sports.model.entity.Outlog;

@Controller
@RequestMapping("/sport")
public class SportController {

	@Autowired
	public IntologDao ind;
	
	@Autowired
	public OutlogDao otd;
	
	@RequestMapping
	public void index(Model model) {
		Iterable<Intolog> intologs = ind.findAll();
		Iterable<Outlog> outlogs = otd.findAll();
		List<Intolog> intos = new ArrayList<>();
		List<Outlog>  outs = new ArrayList<>();
		model.addAttribute("intologs", intologs);
		model.addAttribute("outlogs", outlogs);
		
	}
}

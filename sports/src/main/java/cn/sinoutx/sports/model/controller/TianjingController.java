package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.entity.Equipment;

@Controller
@RequestMapping("/tianjing")
public class TianjingController {

	@Autowired
	public EquipmentDao ed;
	
	@RequestMapping
	private void index(Model model) {
		Iterable<Equipment> equipments = ed.findAll();
		model.addAttribute("eqtj", equipments);

	}
}

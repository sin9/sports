package cn.sinoutx.sports.model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.dao.IntologDao;
import cn.sinoutx.sports.model.dao.OutlogDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqtype;
import cn.sinoutx.sports.model.entity.Equipment;
import cn.sinoutx.sports.model.entity.Intolog;
import cn.sinoutx.sports.model.entity.Outlog;
import cn.sinoutx.sports.model.services.EquipmentService;

@Controller
@RequestMapping("/sport")
public class SportController {

	@Autowired
	public IntologDao ind;
	
	@Autowired
	public OutlogDao otd;
	
	@Autowired
	public EquipmentService es;
	
	@Autowired
	public EquipmentDao ed;
	
	@RequestMapping
	public void index(Model model) {
		Iterable<Intolog> intologs = ind.findAll();
		Iterable<Outlog> outlogs = otd.findAll();
		List<Intolog> intos = new ArrayList<>();
		List<Outlog>  outs = new ArrayList<>();
		model.addAttribute("intologs", intologs);
		model.addAttribute("outlogs", outlogs);
		
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteeq(@PathVariable Integer id,Model model) {
	
		Equipment em = ed.findOne(id);
		if(em == null) {
		es.deleteeq(id);
		return "redirect:/allequipment";
		}else {
			model.addAttribute("error", "操作失败");
			return "redirect:/allequipment/edit/"+id;
		}
	}
}

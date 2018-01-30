package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EqtypeDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqtype;
import cn.sinoutx.sports.model.services.EquipmentService;

@Controller
@RequestMapping("/edit")
public class EditController {
	@Autowired
	public EqnameDao eqd;
	
	@Autowired
	public EquipmentDao ed;
	
	@Autowired
	public EqtypeDao etd;

	@Autowired
	public EquipmentService es;
	
	@RequestMapping(value = "/edit/{id}")
	public void editeq(@PathVariable Integer id,Model model) {
	
	Eqname equip = eqd.findOne(id);

	Iterable<Eqtype> eqtypes = etd.findAll();
	
		model.addAttribute("eqi", equip);
		model.addAttribute("eqtypes", eqtypes);

	}
	
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	public String edit(String detail,Integer eqtid,Integer id,Model model) {
		int a = es.updateequip(detail, eqtid, id);
		if(a>0) {
			return "redirect:/allequipment";
		}else {
			model.addAttribute("error", "操作失败");
			return "redirect:/edit/"+id;
		}
	}
}

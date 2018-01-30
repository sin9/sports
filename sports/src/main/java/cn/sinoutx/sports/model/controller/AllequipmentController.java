package cn.sinoutx.sports.model.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.sinoutx.sports.model.entity.Equipment;
import cn.sinoutx.sports.model.services.EquipmentService;

@Controller
@RequestMapping("/allequipment")
public class AllequipmentController {

	@Autowired
	public EqnameDao eqd;
	
	@Autowired
	public EquipmentDao ed;
	
	@Autowired
	public EqtypeDao etd;

	@Autowired
	public EquipmentService es;
	
	@RequestMapping
	public void index(Model model) {
	Iterable<Eqname> eqnames = eqd.findAll();
	//freemarker遍历key为实体类的map好像有问题
	List<Eqname> eqinfo = new ArrayList<>();
		for (Eqname eqname : eqnames) {
			if(ed.countbyeqname(eqname)!=null) {
				eqname.setCount(ed.countbyeqname(eqname));
				
			}else {
				eqname.setCount(0l);
				 eqinfo.add(eqname);
			}
			 eqinfo.add(eqname);
			 System.out.println(ed.countbyeqname(eqname));
		}
		model.addAttribute("eqinfo", eqinfo);

	}

	
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
			return "redirect:/allequipment/edit/"+id;
		}
	}
	
	
}

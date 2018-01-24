package cn.sinoutx.sports.model.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.entity.Eqname;

@Controller
@RequestMapping("/allequipment")
public class AllequipmentController {

	@Autowired
	public EqnameDao eqd;
	
	@Autowired
	public EquipmentDao ed;
	
	
	
	@RequestMapping
	private void index(Model model) {
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
}

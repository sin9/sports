package cn.sinoutx.sports.model.controller;

import java.util.HashMap;
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
	Map< Eqname,Integer> eqinfo = new HashMap<>();
		for (Eqname eqname : eqnames) {
			if(ed.countbyeqname(eqname)!=null) {
				 eqinfo.put(eqname,ed.countbyeqname(eqname));
				 System.out.println(eqname);
			}else {
				 eqinfo.put(eqname,0);
			}
			
		}
		model.addAttribute("eqinfo", eqinfo);

	}
}

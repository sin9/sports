package cn.sinoutx.sports.model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.entity.Eqname;

@Controller
@RequestMapping("/rentequipment")
public class RentequipmentController {

	@Autowired
	public EqnameDao end;
	@Autowired
	public EquipmentDao ed;
	
	@RequestMapping
	private void index(Model model) {
		
		Iterable<Eqname> eqnames = end.findAll();
		List<Eqname> eqinfo = new ArrayList<>();
		for (Eqname eqname : eqnames) {
			if(ed.countbyeqname(eqname)!=null) {
				eqname.setCount(ed.countbyeqname(eqname));
				
			}else {
				eqname.setCount(0l);
				 eqinfo.add(eqname);
			}
			 eqinfo.add(eqname);
		}
		model.addAttribute("eqnames", eqinfo);

	}
}

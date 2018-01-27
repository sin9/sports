package cn.sinoutx.sports.model.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.User;
import cn.sinoutx.sports.model.services.EquipmentService;

@Controller
@RequestMapping("/rentequipment")
public class RentequipmentController {

	@Autowired
	public EqnameDao end;
	@Autowired
	public EquipmentDao ed;
	
	@Autowired
	public EquipmentService eqs;
	
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
	
	@RequestMapping(method=RequestMethod.POST)
	private String add(Integer eqnid,Integer number,String rentname,Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		 System.out.println(">>>>>>>>>>" +eqnid+"sssssssss"+number+"oooooooo"+rentname);
		int a = eqs.addOutlogand(eqnid, number, user, rentname);
		if(a>0) {
			model.addAttribute("error", "操作成功");
			return "redirect:/rentequipment";
		}else {
			model.addAttribute("error", "操作失败");
			return "redirect:/rentequipment";
		}
		
	}
}

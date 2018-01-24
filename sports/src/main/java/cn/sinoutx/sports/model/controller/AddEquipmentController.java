package cn.sinoutx.sports.model.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EqstateDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.dao.IntologDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqstate;
import cn.sinoutx.sports.model.entity.User;

@Controller
@RequestMapping("/addequipment")
public class AddEquipmentController {

	@Autowired
	public EqnameDao end;
	
	@Autowired
	public EquipmentDao eqd;
	
	@Autowired
	public EqstateDao esd;
	
	@Autowired
	public IntologDao ind;
	
	@RequestMapping
	private void index(Model model) {
		Iterable<Eqname> eqnames = end.findAll();
		model.addAttribute("eqnames", eqnames);
		

	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	private String add(String modules,Integer number,Model model,HttpSession session) {
		Eqname eqn = end.findByName(modules);
		Eqstate eqs = esd.findOne(1);
		User user = (User)session.getAttribute("user");
		for(int i=0;i<number;i++) {
			eqd.addEquipment(eqn, eqs, new Date());
		}
		ind.addEquipment(new Date(), eqn, number, user);
		return "redirect:/allequipment";
	}
}

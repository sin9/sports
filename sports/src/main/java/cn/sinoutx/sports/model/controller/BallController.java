package cn.sinoutx.sports.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.EqtypeDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.entity.Eqtype;
import cn.sinoutx.sports.model.entity.Equipment;

@Controller
@RequestMapping("/ball")
public class BallController {

	@Autowired
	public EquipmentDao ed;
	
	@Autowired
	public EqtypeDao eqd;
	
	@RequestMapping
	private void index(Model model) {
		Eqtype eqtype = eqd.findOne(2);
		List<Equipment> equipments = ed.findByEqtype(eqtype);
		model.addAttribute("eqtj", equipments);

	}
}

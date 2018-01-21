package cn.sinoutx.sports.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EqstateDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqstate;
import cn.sinoutx.sports.model.entity.Equipment;
import cn.sinoutx.sports.model.mappers.EquipmentMapper;

@Controller
@RequestMapping("/allequipment")
public class AllequipmentController {

	@Autowired
	public EqnameDao eqd;
	
	@Autowired
	public EqstateDao esd;
	
	public EquipmentMapper eqm;
	
	@RequestMapping
	private void index(Model model) {
	Iterable<Eqname> eqnames = eqd.findAll();
	Iterable<Eqstate> eqstates = esd.findAll();
		for (Eqname eqname : eqnames) {
			for (Eqstate eqstate : eqstates) {
				 eqm.countEquipByEnameOrEqstate(eqname, eqstate);
			}
		}

	}
}

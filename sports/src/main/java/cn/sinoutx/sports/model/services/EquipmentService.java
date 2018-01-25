package cn.sinoutx.sports.model.services;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EqstateDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.dao.IntologDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqstate;
import cn.sinoutx.sports.model.entity.User;

@Service
public class EquipmentService {
	@Autowired
	public EqnameDao end;
	
	@Autowired
	public EquipmentDao eqd;
	
	@Autowired
	public EqstateDao esd;
	
	@Autowired
	public IntologDao ind;
	
	/**
	 * 添加记录
	 * @param modules
	 * @param number
	 * @param model
	 * @param user
	 * @return
	 */
	@Transactional
	public Integer add(Integer eqnid,Integer number,User user) {
		Eqname eqn = end.findOne(eqnid);
		Eqstate eqs = esd.findOne(1);
		for(int i=0;i<number;i++) {
			eqd.addEquipment(eqn, eqs, new Date());
		}
		int a = ind.addEquipment(new Date(), eqn, number, user);
		return a;
	}

}

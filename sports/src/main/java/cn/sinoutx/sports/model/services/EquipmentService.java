package cn.sinoutx.sports.model.services;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.sinoutx.sports.model.dao.EqnameDao;
import cn.sinoutx.sports.model.dao.EqstateDao;
import cn.sinoutx.sports.model.dao.EqtypeDao;
import cn.sinoutx.sports.model.dao.EquipmentDao;
import cn.sinoutx.sports.model.dao.IntologDao;
import cn.sinoutx.sports.model.dao.OutlogDao;
import cn.sinoutx.sports.model.dao.ReturnlogDao;
import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqstate;
import cn.sinoutx.sports.model.entity.Eqtype;
import cn.sinoutx.sports.model.entity.Equipment;
import cn.sinoutx.sports.model.entity.Outlog;
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
	
	@Autowired
	public OutlogDao otd;
	@Autowired
	public ReturnlogDao rld;
	
	@Autowired
	public EqtypeDao etd;
	
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
	/**
	 * 出库
	 * @param eqnid
	 * @param number
	 * @param user
	 * @param name
	 * @return
	 */
	@Transactional
	public Integer addOutlogand(Integer eqnid,Integer number,User user,String name) {
		Eqname eqn = end.findOne(eqnid);
		Eqstate eqsno = esd.findOne(1);
		List<Equipment> equips = eqd.findByEqnameAndEqstate(eqn, eqsno);
		Eqstate eqs = esd.findOne(3);
		for(int i=0;i<number;i++) {
			eqd.updateState(eqs, equips.get(i).getEid());
		}
		int b = otd.addOutlog(new Date(), eqn, number, user, name);
		return b;
	}
	/**
	 * 归还记录
	 * @param outlog
	 * @param number
	 * @param retname
	 * @param des
	 * @param user
	 * @return
	 */
	@Transactional
	public Integer addReturnlogand(Integer outlog,Integer number,String retname,String des,User user) {
		Outlog ol = otd.findOne(outlog);
		Eqname eqn = ol.getEqnid();
		Eqstate eqsno = esd.findOne(3);
		List<Equipment> equips = eqd.findByEqnameAndEqstate(eqn, eqsno);
		Eqstate eqs = esd.findOne(1);
		for(int i=0;i<number;i++) {
			eqd.updateState(eqs, equips.get(i).getEid());
		}
		int b = rld.addEquipment(new Date(), des, eqn, number, user, retname, ol);
		return b;
	}
/**
 * 更新器材信息
 * @param detail
 * @param eqtid
 * @param id
 * @return
 */
	@Transactional
	public Integer updateequip(String detail,Integer eqtid,Integer id) {
		Eqtype eqt = etd.findOne(eqtid);
		return end.updateState(detail, eqt, id);
	}
	@Transactional
	public void deleteeq(Integer id) {
	
		eqd.delete(id);
		
	}
}

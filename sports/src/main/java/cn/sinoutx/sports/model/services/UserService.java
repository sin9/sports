package cn.sinoutx.sports.model.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sinoutx.sports.model.dao.UserDao;

@Service
public class UserService {

	@Autowired
	public UserDao ud;
	
	@Transactional
	public Integer update(String uname,String gender,String email,String address,String tel,Integer uid) {
		return ud.update(uname, gender, email, address, tel, uid);
	}

	@Transactional
	public int updatePassword(String newpassword, Integer uid) {
		
		return ud.updatepass(newpassword, uid);
	}
	
	@Transactional
	public void delete(Integer uid) {
		
		 ud.delete(uid);;
	}
}

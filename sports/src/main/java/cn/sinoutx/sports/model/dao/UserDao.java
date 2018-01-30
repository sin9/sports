package cn.sinoutx.sports.model.dao;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.User;

public interface UserDao extends CrudRepository<User , Integer> {

	 public List<User> findByUname(String username);
	
	 @Modifying
	 @Query(value = "update User set uname = ?1,gender = ?2,email = ?3,address = ?4,tel = ?5 where uid = ?6",nativeQuery = true)
	 int update(String uname,String gender,String email,String address,String tel,Integer uid);
	 
	 @Modifying
	 @Query(value = "update User set password = ?1 where uid = ?2",nativeQuery = true)
	 int updatepass(String password,Integer uid);
}

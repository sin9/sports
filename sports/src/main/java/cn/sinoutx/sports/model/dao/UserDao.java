package cn.sinoutx.sports.model.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.User;

public interface UserDao extends CrudRepository<User , Integer> {

	 public List<User> findByUname(String username);
	
}

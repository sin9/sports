package cn.sinoutx.sports.model.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Intolog;
import cn.sinoutx.sports.model.entity.User;

public interface IntologDao extends CrudRepository<Intolog, Integer> {

	@Modifying
    @Query(value = "insert into Intolog(intodate,eqname,num,user) values(?1,?2,?3,?4)",nativeQuery = true)
    int addEquipment(Date intodate,Eqname eqname,Integer num,User user);
}

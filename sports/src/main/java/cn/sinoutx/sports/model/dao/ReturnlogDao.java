package cn.sinoutx.sports.model.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Outlog;
import cn.sinoutx.sports.model.entity.Returnlog;
import cn.sinoutx.sports.model.entity.User;

public interface ReturnlogDao extends CrudRepository<Returnlog, Integer> {

	@Modifying
    @Query(value = "insert into Returnlog(redate,redes,eqname,returnnum,user,retname,outlog) values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    int addEquipment(Date redate,String redes,Eqname eqname,Integer outnum,User user,String retname,Outlog outlog);
}

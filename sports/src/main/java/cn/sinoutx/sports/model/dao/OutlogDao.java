package cn.sinoutx.sports.model.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Outlog;
import cn.sinoutx.sports.model.entity.User;

public interface OutlogDao extends CrudRepository<Outlog, Integer> {

	@Modifying
    @Query(value = "insert into Outlog(outdate,eqname,outnum,user,outname) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    int addOutlog(Date outdate,Eqname eqname,Integer outnum,User user,String outname);
}

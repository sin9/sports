package cn.sinoutx.sports.model.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqstate;
import cn.sinoutx.sports.model.entity.Eqtype;

public interface EqnameDao extends CrudRepository<Eqname, Integer> {

	Eqname findByName(String name);
	@Modifying
    @Query(value = "update Equipment set detail = ?1,eqtype = ?2 where eqnid = ?2",nativeQuery = true)
    int updateState(String detail,Eqtype eqt,Integer eqnid);
}

package cn.sinoutx.sports.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqstate;
import cn.sinoutx.sports.model.entity.Eqtype;
import cn.sinoutx.sports.model.entity.Equipment;

public interface EquipmentDao extends CrudRepository<Equipment, Integer> {

	@Query("select count(*) from Equipment e where e.eqnid = ?1")
	Long countbyeqname(Eqname eqname);
	
	@Query("select e from Equipment e join e.eqnid n where n.eqtid = ?1")
	List<Equipment> findByEqtype(Eqtype eqtid);
	
	@Query("select e from Equipment e where eqname = ?1 and eqstate = ?2")
	List<Equipment> findByEqnameAndEqstate(Eqname eqname,Eqstate eqstate);
	
	@Modifying
    @Query(value = "insert into Equipment(eqname,eqstate,indate) values(?1,?2,?3)",nativeQuery = true)
    int addEquipment(Eqname eqname,Eqstate eqstate,Date indate);
	
	@Modifying
    @Query(value = "update Equipment set eqstate = ?1 where eid = ?2",nativeQuery = true)
    int updateState(Eqstate eqstate,Integer eid);
	
	
}

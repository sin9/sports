package cn.sinoutx.sports.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqtype;
import cn.sinoutx.sports.model.entity.Equipment;

public interface EquipmentDao extends CrudRepository<Equipment, Integer> {

	@Query("select count(*) from Equipment e where e.eqnid = ?1")
	Integer countbyeqname(Eqname eqname);
	
	@Query("select e from Equipment e join e.eqnid n where n.eqtid = ?1")
	List<Equipment> findByEqtype(Eqtype eqtid);
}

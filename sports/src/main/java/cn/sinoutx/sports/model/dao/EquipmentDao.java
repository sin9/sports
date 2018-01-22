package cn.sinoutx.sports.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Equipment;

public interface EquipmentDao extends CrudRepository<Equipment, Integer> {

	@Query("select count(*) from Equipment e where e.eqnid = ?1")
	Integer countbyeqname(Eqname eqname);
}

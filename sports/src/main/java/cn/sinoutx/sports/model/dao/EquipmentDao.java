package cn.sinoutx.sports.model.dao;

import org.springframework.data.repository.CrudRepository;

import cn.sinoutx.sports.model.entity.Equipment;

public interface EquipmentDao extends CrudRepository<Equipment, Integer> {

}

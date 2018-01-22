package cn.sinoutx.sports.model.mappers;

import org.apache.ibatis.annotations.Param;

import cn.sinoutx.sports.model.entity.Eqname;

public interface EquipmentMapper {

	Integer countEquipByEnameOrEqstate(@Param("eqname") Eqname eqname);
}

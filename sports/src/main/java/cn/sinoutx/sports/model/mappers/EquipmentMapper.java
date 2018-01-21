package cn.sinoutx.sports.model.mappers;

import org.apache.ibatis.annotations.Param;

import cn.sinoutx.sports.model.entity.Eqname;
import cn.sinoutx.sports.model.entity.Eqstate;

public interface EquipmentMapper {

	Integer countEquipByEnameOrEqstate(@Param("eqname") Eqname eqname,@Param("eqstate") Eqstate eqstate);
}

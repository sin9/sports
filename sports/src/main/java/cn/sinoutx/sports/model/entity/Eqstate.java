package cn.sinoutx.sports.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="eqstate")
public class Eqstate {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eqsid;
	
	@Column
	private String eqsname;
	
	@Column
	@OneToMany(mappedBy="eqsid")
	private List<Equipment> equipments;
	
	public Eqstate() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEqsid() {
		return eqsid;
	}

	public void setEqsid(Integer eqsid) {
		this.eqsid = eqsid;
	}

	public String getEqsname() {
		return eqsname;
	}

	public void setEqsname(String eqsname) {
		this.eqsname = eqsname;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	
	
}

package cn.sinoutx.sports.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="eqname")
public class Eqname {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eqid;
	
	@Column
	private String name;
	
	@Column
	@OneToMany(mappedBy="eqnid")
	private List<Equipment> equipments;
	
	@ManyToOne
	@JoinColumn(name="eqtype")
	private Eqtype eqtid;
	
	@Column
	private String detail;
	
	public Eqname() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEqid() {
		return eqid;
	}

	public void setEqid(Integer eqid) {
		this.eqid = eqid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Eqtype getEqtid() {
		return eqtid;
	}

	public void setEqtid(Eqtype eqtid) {
		this.eqtid = eqtid;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}

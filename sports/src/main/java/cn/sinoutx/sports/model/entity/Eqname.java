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
	private Integer eqnid;
	
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
	
	@Column
	@OneToMany(mappedBy="eqnid")
	private List<Intolog> intologs;
	
	@Column
	@OneToMany(mappedBy="eqnid")
	private List<Outlog> outlogs;
	
	@Column
	@OneToMany(mappedBy="eqnid")
	private List<Returnlog> returnlogs;
	//统计数量
	private Long count;
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<Outlog> getOutlogs() {
		return outlogs;
	}

	public void setOutlogs(List<Outlog> outlogs) {
		this.outlogs = outlogs;
	}

	public List<Returnlog> getReturnlogs() {
		return returnlogs;
	}

	public void setReturnlogs(List<Returnlog> returnlogs) {
		this.returnlogs = returnlogs;
	}

	public Eqname() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEqnid() {
		return eqnid;
	}

	public void setEqnid(Integer eqnid) {
		this.eqnid = eqnid;
	}

	public List<Intolog> getIntologs() {
		return intologs;
	}

	public void setIntologs(List<Intolog> intologs) {
		this.intologs = intologs;
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

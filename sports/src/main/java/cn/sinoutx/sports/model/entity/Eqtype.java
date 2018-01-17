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
@Table(name="eqtype")
public class Eqtype {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eqtid;
	
	@Column
	private String eqtname;
	
	@Column
	@OneToMany(mappedBy="eqtid")
	private List<Eqname> eqnames;
	
	public Eqtype() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEqtid() {
		return eqtid;
	}

	public void setEqtid(Integer eqtid) {
		this.eqtid = eqtid;
	}

	public String getEqtname() {
		return eqtname;
	}

	public void setEqtname(String eqtname) {
		this.eqtname = eqtname;
	}

	public List<Eqname> getEqnames() {
		return eqnames;
	}

	public void setEqnames(List<Eqname> eqnames) {
		this.eqnames = eqnames;
	}
	
	

}

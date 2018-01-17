package cn.sinoutx.sports.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="equipment")
public class Equipment {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	
	@ManyToOne()
	@JoinColumn(name="eqname")
	private Eqname eqnid;
	
	@Column
	private Date indate;

	public Equipment() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Eqname getEqnid() {
		return eqnid;
	}

	public void setEqnid(Eqname eqnid) {
		this.eqnid = eqnid;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
}

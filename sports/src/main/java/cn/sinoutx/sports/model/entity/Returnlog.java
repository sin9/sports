package cn.sinoutx.sports.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="returnlog")
public class Returnlog {


	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reid;
	
	@Column
	private String rename;
	
	@Column
	private Date redate;
	
	@ManyToOne
	@JoinColumn(name="eqname")
	private Eqname eqnid;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "outlog")
	private Outlog outid;
	
	@Column
	private Integer returnnum;
	
	@Column
	private String redes;//归还描述
	
	@ManyToOne
	@JoinColumn(name="user")
	private User uid;//操作人
	
	public Returnlog() {
		// TODO Auto-generated constructor stub
	}

	public Integer getReid() {
		return reid;
	}

	public void setReid(Integer reid) {
		this.reid = reid;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public Date getRedate() {
		return redate;
	}

	public void setRedate(Date redate) {
		this.redate = redate;
	}

	public Eqname getEqnid() {
		return eqnid;
	}

	public void setEqnid(Eqname eqnid) {
		this.eqnid = eqnid;
	}

	public Outlog getOutid() {
		return outid;
	}

	public void setOutid(Outlog outid) {
		this.outid = outid;
	}

	public Integer getReturnnum() {
		return returnnum;
	}

	public void setReturnnum(Integer returnnum) {
		this.returnnum = returnnum;
	}

	public String getRedes() {
		return redes;
	}

	public void setRedes(String redes) {
		this.redes = redes;
	}

	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}
	
	
}

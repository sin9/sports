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
@Table(name="outlog")
public class Outlog {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer outid;
	
	@Column
	private String outname;
	
	@Column
	private Date outdate;
	
	@ManyToOne
	@JoinColumn(name="eqname")
	private Eqname eqnid;
	
	@Column
	private Integer outnum;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User usid;//操作人
	
	@OneToOne(mappedBy="outid")
	private Returnlog reid;
	
	public Returnlog getReid() {
		return reid;
	}

	public void setReid(Returnlog reid) {
		this.reid = reid;
	}

	public Outlog() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOutid() {
		return outid;
	}

	public void setOutid(Integer outid) {
		this.outid = outid;
	}

	public String getOutname() {
		return outname;
	}

	public void setOutname(String outname) {
		this.outname = outname;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public Eqname getEqnid() {
		return eqnid;
	}

	public void setEqnid(Eqname eqnid) {
		this.eqnid = eqnid;
	}

	public Integer getOutnum() {
		return outnum;
	}

	public void setOutnum(Integer outnum) {
		this.outnum = outnum;
	}

	public User getUsid() {
		return usid;
	}

	public void setUsid(User usid) {
		this.usid = usid;
	}
	
	
}

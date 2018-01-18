package cn.sinoutx.sports.model.entity;

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
@Table(name="intolog")
public class Intolog {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inid;
	
	@Column
	private Date intodate;
	
	@ManyToOne
	@JoinColumn(name="eqname")
	private Eqname eqnid;
	
	@Column
	private Integer num;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User uid;//操作人
	
	public Intolog() {
		// TODO Auto-generated constructor stub
	}

	public Integer getInid() {
		return inid;
	}

	public void setInid(Integer inid) {
		this.inid = inid;
	}

	public Date getIntodate() {
		return intodate;
	}

	public void setIntodate(Date intodate) {
		this.intodate = intodate;
	}

	public Eqname getEqnid() {
		return eqnid;
	}

	public void setEqnid(Eqname eqnid) {
		this.eqnid = eqnid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}
	
	
	
}

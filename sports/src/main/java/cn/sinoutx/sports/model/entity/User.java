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
@Table(name="user")
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	
	@Column
	private String uname;
	
	@Column
	private String gender;
	
	@ManyToOne
	@JoinColumn(name="role")
	private Role rid;
	
	@Column
	private String tel;
	
	@Column
	private String address;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	@OneToMany(mappedBy="uid")
	private List<Intolog> intologs;
	
	@Column
	@OneToMany(mappedBy="usid")
	private List<Outlog> outlogs;
	
	@Column
	@OneToMany(mappedBy="uid")
	private List<Returnlog> returnlogs;
	
	public List<Returnlog> getReturnlogs() {
		return returnlogs;
	}

	public void setReturnlogs(List<Returnlog> returnlogs) {
		this.returnlogs = returnlogs;
	}

	public List<Intolog> getIntologs() {
		return intologs;
	}

	public void setIntologs(List<Intolog> intologs) {
		this.intologs = intologs;
	}

	public List<Outlog> getOutlogs() {
		return outlogs;
	}

	public void setOutlogs(List<Outlog> outlogs) {
		this.outlogs = outlogs;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Role getRid() {
		return rid;
	}

	public void setRid(Role rid) {
		this.rid = rid;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

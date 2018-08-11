package com.superhero.netctoos.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_login_log")
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = -6603624644255312301L;
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "identity")
	@GeneratedValue(generator = "hibernate.id")
	private long id;
	@Column(name="login_name")
	private String loginName;
	@Column(name="login_time")
	private Date loginTime;
	@Column(name="login_type")
	private boolean loginType;
	@Column(name="login_ip_address")
	private String loginIpAddress;
	@Column(name="login_exit")
	private boolean loginExit;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public boolean isLoginType() {
		return loginType;
	}
	public void setLoginType(boolean loginType) {
		this.loginType = loginType;
	}
	public String getLoginIpAddress() {
		return loginIpAddress;
	}
	public void setLoginIpAddress(String loginIpAddress) {
		this.loginIpAddress = loginIpAddress;
	}
	public boolean isLoginExit() {
		return loginExit;
	}
	public void setLoginExit(boolean loginExit) {
		this.loginExit = loginExit;
	}
	
}

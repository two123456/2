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
@Table(name = "t_account_bill_year")
public class AccountBillYearBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9095916277520313769L;
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.id", strategy = "identity")
	@GeneratedValue(generator = "hibernate.id")
	private long id;

	@Column(name = "cost")
	/** 总费用 */
	private Double cost;

	@Column(name = "year_time")
	/** 年份账单 */
	private Date yearTime;

	@Column(name = "user_name", length = 20)
	/** 用户真实姓名 */
	private String userName;
	@Column(name = "account", length = 20)
	/** 业务账号 */
	private String account;
	
	/** 实验室ip*/
	private String serverIp;
	
	/** 有效时间*/
	private double validTime;
	

	public AccountBillYearBean(long id, Double cost, Date yearTime, String userName, String account, String serverIp,
			double validTime) {
		super();
		this.id = id;
		this.cost = cost;
		this.yearTime = yearTime;
		this.userName = userName;
		this.account = account;
		this.serverIp = serverIp;
		this.validTime = validTime;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public double getValidTime() {
		return validTime;
	}

	public void setValidTime(double validTime) {
		this.validTime = validTime;
	}

	public AccountBillYearBean() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getYearTime() {
		return yearTime;
	}

	public void setYearTime(Date yearTime) {
		this.yearTime = yearTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AccountBillYearBean [id=" + id + ", cost=" + cost + ", yearTime=" + yearTime + ", userName=" + userName
				+ ", account=" + account + ", serverIp=" + serverIp + ", validTime=" + validTime + "]";
	}

}

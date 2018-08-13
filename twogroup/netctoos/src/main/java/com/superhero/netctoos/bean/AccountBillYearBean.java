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
	/** 账务账号 */
	private String account;

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
				+ ", account=" + account + "]";
	}

}

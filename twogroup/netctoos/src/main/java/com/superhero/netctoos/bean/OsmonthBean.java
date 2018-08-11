package com.superhero.netctoos.bean;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

/**
 * 业务账单(月)实体类
 * 
 * @author xsy
 *
 */
@Entity
@Table(name = "t_osmonth")
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class OsmonthBean implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -8552891844233928884L;
	

	/** 业务账单(月)id */
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private long id;
	/** 费用 */
	@Column(name = "cost")
	private double cost;
	/** 有效时间 */
	@Column(name = "valid_time")
	private double validTime;
	/** 使用时间 */
	@Column(name = "use_time")
	private Date useTime;
	/** 业务账号 */
	@Column(name = "os_account")
	private String osAccount;
	/** 资费套餐 */
	@Column(name = "tariff_combo")
	private String tariffCombo;
	/** 服务器Ip */
	@Column(name = "server_ip")
	private String serverIp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getValidTime() {
		return validTime;
	}

	public void setValidTime(double validTime) {
		this.validTime = validTime;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public String getOsAccount() {
		return osAccount;
	}

	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}

	public String getTariffCombo() {
		return tariffCombo;
	}

	public void setTariffCombo(String tariffCombo) {
		this.tariffCombo = tariffCombo;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	@Override
	public String toString() {
		return "Osday [id=" + id + ", cost=" + cost + ", validTime=" + validTime + ", useTime=" + useTime
				+ ", osAccount=" + osAccount + ", tariffCombo=" + tariffCombo + ", serverIp=" + serverIp + "]";
	}

}

package com.superhero.netctoos.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 业务账号表
 * 
 * @author xiasuiying
 *
 */
@Entity
@Table(name = "t_os")
public class OsBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 7651426911465491850L;
	/** 业务账号id */
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private long id;
	/** 账号 */
	@Column(name = "os_account")
	private String osAccount;
	/** 密码 */
	@Column(name = "os_pwd")
	private String osPwd;
	/** 状态 */
	@Column(name = "os_state")
	private int osState;
	// 状态(sql转化)
	private String osStatus;

	/** 服务器类 */
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL })
	@JoinColumn(name = "fk_server_id")
	private ServerBean serverBean;

	// 姓名
	private String userName;
	// 账务账号
	private String account;
	// 资费方式
	private String tariff;

	
	public String getOsStatus() {
		return osStatus;
	}

	public void setOsStatus(String osStatus) {
		this.osStatus = osStatus;
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

	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOsAccount() {
		return osAccount;
	}

	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}

	public String getOsPwd() {
		return osPwd;
	}

	public void setOsPwd(String osPwd) {
		this.osPwd = osPwd;
	}

	public int getOsState() {
		return osState;
	}

	public void setOsState(int osState) {
		this.osState = osState;
	}

	public ServerBean getServerBean() {
		return serverBean;
	}

	public void setServerBean(ServerBean serverBean) {
		this.serverBean = serverBean;
	}

	@Override
	public String toString() {
		return "OsBean [id=" + id + ", osAccount=" + osAccount + ", osPwd=" + osPwd + ", osState=" + osState
				+ ", serverBean=" + serverBean + "]";
	}

}

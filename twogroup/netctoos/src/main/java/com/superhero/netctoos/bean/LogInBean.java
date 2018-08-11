package com.superhero.netctoos.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 登陆日志实体类
 * 
 * @author xiasuiying
 *
 */
@Entity
@Table(name = "t_log_in")
public class LogInBean implements Serializable {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 6688308088587180347L;
	/** 登陆日志id */
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private long id;
	/** 登陆人员 */
	@Column(name = "log_name")
	private String logName;
	/** 登陆/登出时间 */
	@Column(name = "log_time")
	private Date logTime;
	/** 登陆IP地址 */
	@Column(name = "server_ip")
	private String serverIp;
	/** 登陆/退出 */
	@Column(name = "enter")
	private int enter;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public int getEnter() {
		return enter;
	}

	public void setEnter(int enter) {
		this.enter = enter;
	}

	@Override
	public String toString() {
		return "LogInBean [id=" + id + ", logName=" + logName + ", logTime=" + logTime + ", serverIp=" + serverIp
				+ ", enter=" + enter + "]";
	}

}

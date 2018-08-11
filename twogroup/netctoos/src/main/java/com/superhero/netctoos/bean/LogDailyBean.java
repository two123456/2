package com.superhero.netctoos.bean;

import java.io.Serializable;
import java.util.Date;

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
 * 操作日志实体类
 * @author jkkp123
 *
 */
@Entity
@Table(name = "t_log_daily")
public class LogDailyBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1277862041359086242L;
  /**操作日志id*/
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private long id;
	/**操作人员*/
	@Column(name = "daily_name")
  private String dailyName;
  /**操作时间*/
	@Column(name = "daily_time")
  private Date dailyTime;
  /**操作模块*/
	@Column(name = "daily_mod")
  private String dailyMod;
  /**操作类型*/
	@Column(name = "daily_type")
  private int dailyType;
	/**日志数据类*/
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_info_id")
  private LogInfoBean logInfo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDailyName() {
		return dailyName;
	}
	public void setDailyName(String dailyName) {
		this.dailyName = dailyName;
	}
	public Date getDailyTime() {
		return dailyTime;
	}
	public void setDailyTime(Date dailyTime) {
		this.dailyTime = dailyTime;
	}
	public String getDailyMod() {
		return dailyMod;
	}
	public void setDailyMod(String dailyMod) {
		this.dailyMod = dailyMod;
	}
	public int getDailyType() {
		return dailyType;
	}
	public void setDailyType(int dailyType) {
		this.dailyType = dailyType;
	}
	public LogInfoBean getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(LogInfoBean logInfo) {
		this.logInfo = logInfo;
	}
	@Override
	public String toString() {
		return "LogDailyBean [id=" + id + ", dailyName=" + dailyName + ", dailyTime=" + dailyTime + ", dailyMod="
				+ dailyMod + ", dailyType=" + dailyType + ", logInfo=" + logInfo + "]";
	}
	
	
}

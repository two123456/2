package com.superhero.netctoos.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 日志数据实体类
 * @author xiasuiying
 *
 */
@Entity
@Table(name = "t_log_info")
public class LogInfoBean implements Serializable {
	/**
	 * 序列化
	 */
	
	private static final long serialVersionUID = -611290605097178738L;
	/**日志数据id*/
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private long id;
	/**操作内容*/
	@Column(name = "daily_info")
	private String dailyInfo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDailyInfo() {
		return dailyInfo;
	}
	public void setDailyInfo(String dailyInfo) {
		this.dailyInfo = dailyInfo;
	}
	@Override
	public String toString() {
		return "LogInfoBean [id=" + id + ", dailyInfo=" + dailyInfo + "]";
	}
	
}

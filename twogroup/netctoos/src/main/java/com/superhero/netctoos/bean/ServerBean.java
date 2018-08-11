package com.superhero.netctoos.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 服务器表
 * 
 * @author xiasuiying'
 *
 */
@Entity
@Table(name = "t_server")
public class ServerBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 2664460862611129617L;
	/** 服务器id */
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private long id;
	/** 服务器IP */
	@Column(name = "server_ip")
	private String serverIp;
	/** 状态 */
	@Column(name = "server_state")
	private int serverState;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public int getServerState() {
		return serverState;
	}
	public void setServerState(int serverState) {
		this.serverState = serverState;
	}
	@Override
	public String toString() {
		return "ServerBean [id=" + id + ", serverIp=" + serverIp + ", serverState=" + serverState + "]";
	}
	
}


package com.superhero.netctoos.bean;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 管理员实体类
 * @author Administrator
 *
 */ 
@Entity
@Table(name="t_admin")
public class AdminBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -873113999172538347L;
    
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	/**管理员id*/
	private Long id;
	
	@Column(name="real_name",length=20)
	/**管理员真实姓名*/
	private String adminName;
	
	@Column(name="admin_account",length=20)
	/**管理员账号*/
	private String adminNum;
	
	@Column(name="admin_pwd",length=20)
	/**管理员密码*/
	private String adminPwd;
	
	@Column(name="admin_tel",length=20)
	/**联系电话*/
	private String adminPhone;
	
	@Column(name="admin_post",length=20)
	/**邮箱*/
	private String adminMail;
	
	/**
	 * 单向关联
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.REFRESH,CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_role_id")
	/**关联角色*/
	private RoleBean role;

	public AdminBean() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminNum() {
		return adminNum;
	}


	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}


	public String getAdminPwd() {
		return adminPwd;
	}


	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}


	public String getAdminPhone() {
		return adminPhone;
	}


	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}


	public String getAdminMail() {
		return adminMail;
	}


	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
   
	

	public RoleBean getRole() {
		return role;
	}


	public void setRole(RoleBean role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "AdministratorBean [id=" + id + ", adminName=" + adminName + ", adminNum=" + adminNum + ", adminPwd="
				+ adminPwd + ", adminPhone=" + adminPhone + ", adminMail=" + adminMail + ", role=" + role + "]";
	}		
}

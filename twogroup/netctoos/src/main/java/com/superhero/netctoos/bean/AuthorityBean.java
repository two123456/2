package com.superhero.netctoos.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
/**
 * 权限实体类
 * @author Administrator
 *
 */ 
@Entity
@Table(name="t_authority")
public class AuthorityBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3297683054551424317L;
	
	
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	/**权限id*/
	private Long id;
		
	@Column(name="authority_name",length=20)
	/**权限名称*/
	private String authorityName;
	
	/**
	 * 双向关联
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.REFRESH})
	@JoinTable(name="t_role_authority",
	joinColumns=@JoinColumn(name="fk_role_id"),
	inverseJoinColumns=@JoinColumn(name="fk_authority_id"))
	/**关联角色*/
	private Set<RoleBean> role;

	public AuthorityBean() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Override
	public String toString() {
		return "AuthorityBean [id=" + id + ", authorityName=" + authorityName + "]";
	}

	   
}


package com.superhero.netctoos.bean;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
/**
 * 角色实体类
 * @author Administrator
 *
 */ 
@Entity
@Table(name="t_role")
public class RoleBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 9024990084295596965L;

	@Id
	  @Column(name="id")
	  @GenericGenerator(name="hibernate.id",strategy="identity")
	  @GeneratedValue(generator="hibernate.id")
	/**角色id*/
	private Long id;
	
	@Column(name="role_name",length=20)
	/**角色名称*/
	private String roleName;
	
	@Column(name="role_type")
	/**角色类型*/
	private int roleType;
	
	/**
	 * 双向关联
	 */
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="role")
	private Set<AuthorityBean> authority;
	
	public RoleBean() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public Set<AuthorityBean> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<AuthorityBean> authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", roleName=" + roleName + ", roleType=" + roleType + ", authority=" + authority
				+ "]";
	}
}


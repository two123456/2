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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 账务账号实体类
 * @author Administrator
 *
 */ 
@Entity
@Table(name="t_account_info")
public class AccountInfoBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -7318090915801581118L;
	
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
    /**账务账号id*/
	private Long id;
	
	@Column(name="account",length=20)
	/**账务账号*/
	private String accountingNum;
	
	@Column(name="user_pwd",length=32)
	/**密码*/
	private String userPwd;
	
	@Column(name="user_name",length=20)
	/**用户真实姓名*/	
	private String userName;
	
	@Column(name="gender")
	/**性别*/
	private int gender;
	
	@Column(name="id_card",length=20)
	/**身份证号*/
	private String peopleCard;
	
	@Column(name="user_tel",length=20)
	/**联系电话*/
	private String phone;
	
	@Column(name="user_address",length=50)
	/**通讯地址*/
	private String address;
	
	@Column(name="post_code",length=20)
	/**邮编*/
	private String postcode;
	
	@Column(name="qq_info",length=20)
	/**QQ信息*/
	private String qqInfo;
	
	@Column(name="account_state")
	/**账号状态*/
	private int numState;
	
	/**
	 * 单向关联
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.REFRESH,CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_role_id")
	/**关联角色*/
	private RoleBean role;	
	
	/**
	 * 双向关联
	 */
	@OneToMany(fetch=FetchType.LAZY,mappedBy="accountInfo")
	@Cascade(value= {CascadeType.REFRESH})
	/**关联账务账单*/
	private Set<AccountBillBean> accountBill;
	
	public AccountInfoBean() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountingNum() {
		return accountingNum;
	}

	public void setAccountingNum(String accountingNum) {
		this.accountingNum = accountingNum;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPeopleCard() {
		return peopleCard;
	}

	public void setPeopleCard(String peopleCard) {
		this.peopleCard = peopleCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getQqInfo() {
		return qqInfo;
	}

	public void setQqInfo(String qqInfo) {
		this.qqInfo = qqInfo;
	}

	public int getNumState() {
		return numState;
	}

	public void setNumState(int numState) {
		this.numState = numState;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

	public Set<AccountBillBean> getAccountBill() {
		return accountBill;
	}

	public void setAccountBill(Set<AccountBillBean> accountBill) {
		this.accountBill = accountBill;
	}

	@Override
	public String toString() {
		return "AccountNumBean [id=" + id + ", accountingNum=" + accountingNum + ", userPwd=" + userPwd + ", userName="
				+ userName + ", gender=" + gender + ", peopleCard=" + peopleCard + ", phone=" + phone + ", address="
				+ address + ", postcode=" + postcode + ", qqInfo=" + qqInfo + ", numState=" + numState + ", role="
				+ role + ", accountBill=" + accountBill + "]";
	}	
}


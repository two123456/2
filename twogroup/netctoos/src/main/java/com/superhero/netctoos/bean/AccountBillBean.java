package com.superhero.netctoos.bean;
import java.io.Serializable;
import java.util.Date;
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
 * 账务账单实体类
 * @author Administrator
 *
 */ 
@Entity
@Table(name="t_account_bill")
public class AccountBillBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3387753571211472587L;
    
	
	
	
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	/**账务账单id*/
	private Long id;
	
	@Column(name="pay_type")
	/**支付方式*/
	private int payWay;
	
	@Column(name="pay_state")
	/**支付状态*/
	private int payState;
	
	@Column(name="month")
	/**月份*/
	private Date Month;
	
	@Column(name="cost")
	/**费用*/
	private Double charge;
	
	/**
	 * 双向关联
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.REFRESH,CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_account_id")
	/**关联账务账号*/
	private AccountInfoBean accountInfo;
	
	public AccountBillBean() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getPayWay() {
		return payWay;
	}


	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}


	public int getPayState() {
		return payState;
	}


	public void setPayState(int payState) {
		this.payState = payState;
	}


	public Date getMonth() {
		return Month;
	}


	public void setMonth(Date month) {
		Month = month;
	}


	public Double getCharge() {
		return charge;
	}


	public void setCharge(Double charge) {
		this.charge = charge;
	}


	public AccountInfoBean getAccountNum() {
		return accountInfo;
	}


	public void setAccountNum(AccountInfoBean accountInfo) {
		this.accountInfo = accountInfo;
	}


	@Override
	public String toString() {
		return "AccountBillBean [id=" + id + ", payWay=" + payWay + ", payState=" + payState + ", Month=" + Month
				+ ", charge=" + charge + ", accountInfo=" + accountInfo + "]";
	}


	
}

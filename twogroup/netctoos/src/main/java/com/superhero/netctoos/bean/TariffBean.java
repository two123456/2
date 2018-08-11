package com.superhero.netctoos.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 资费实体类
 * 
 * @author jkkp123
 *
 */
@Entity
@Table(name = "t_tariff")
public class TariffBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -1827788832732397450L;
	/** 资费id */
	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private long id;
	/** 资费名称 */
	@Column(name = "tariff_name")
	private String tariffName;
	/** 资费类型 */
	@Column(name = "tariff_type")
	private int tariffType;
	/** 基本时长 */
	@Column(name = "time_lengh")
	private double timeLengh;
	/** 基本费用 */
	@Column(name = "basic_cost")
	private double basicCost;
	/** 单位费用 */
	@Column(name = "unit_cost")
	private double unitCost;
	/** 资费说明 */
	@Column(name = "tariff_info")
	private String tariffInfo;
	/** 资费状态 */
	@Column(name = "tariff_state")
	private int tariffState;
	/**业务账号集合*/
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL})
	@JoinColumn(name = "fk_tariff_id")
	private Set<OsBean> osBean;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	public int getTariffType() {
		return tariffType;
	}
	public void setTariffType(int tariffType) {
		this.tariffType = tariffType;
	}
	public double getTimeLengh() {
		return timeLengh;
	}
	public void setTimeLengh(double timeLengh) {
		this.timeLengh = timeLengh;
	}
	public double getBasicCost() {
		return basicCost;
	}
	public void setBasicCost(double basicCost) {
		this.basicCost = basicCost;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public String getTariffInfo() {
		return tariffInfo;
	}
	public void setTariffInfo(String tariffInfo) {
		this.tariffInfo = tariffInfo;
	}
	public int getTariffState() {
		return tariffState;
	}
	public void setTariffState(int tariffState) {
		this.tariffState = tariffState;
	}
	public Set<OsBean> getOsBean() {
		return osBean;
	}
	public void setOsBean(Set<OsBean> osBean) {
		this.osBean = osBean;
	}
	@Override
	public String toString() {
		return "TariffBean [id=" + id + ", tariffName=" + tariffName + ", tariffType=" + tariffType + ", timeLengh="
				+ timeLengh + ", basicCost=" + basicCost + ", unitCost=" + unitCost + ", tariffInfo=" + tariffInfo
				+ ", tariffState=" + tariffState + ", osBean=" + osBean + "]";
	}
	
}

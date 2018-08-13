package com.superhero.netctoos.osmonthmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.OsmonthBean;


/***
 * 按天查询账务账单mybatis映射接口
 * @author wyr
 *
 */
public interface OsMonthQueryMapper {
	/***
	 * 根据账务账号，业务账号，日期查询账务账单数量
	 * @param params
	 * @return
	 */
	@Select("<script>"+ "select count(*) from t_osmonth osm " +
			"		<where>" + 
			"			<if test='params.osAccount != null and params.osAccount !=\"\"'>" + 
			"				and osm.os_account like concat(#{params.osAccount},'%')" + 
			"			</if>" + 
			"			<if test='params.Account != null and params.Account !=\"\"'>" + 
			"				and osm.account = #{params.Account}" + 
			"			</if>" + 
			"			<if test='params.startTime != null and params.startTime !=\"\"'>" + 
			"				and osm.use_time &gt;= #{params.startTime} " + 
			"			</if>" + 
			"			<if test='params.endTime != null and params.endTime !=\"\"'>" + 
			"				and osm.use_time &lt;= #{params.endTime} " + 
			"			</if>" + 
			"		</where>" + 
	 "</script>")
	int countOsDayQueryByParams(@Param("params")Map params);
	/***
	 * 根据账务账号，业务账号，日期查询账务账单
	 * @param params
	 * @return
	 */
	@Results({@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="cost",column="cost",javaType=double.class),
		@Result(property="useTime",column="use_time",javaType=Date.class),
		@Result(property="serverIp",column="server_ip",javaType=String.class),
		@Result(property="validTime",column="valid_time",javaType=double.class),
		@Result(property="osAccount",column="os_account",javaType=String.class),
		@Result(property="Account",column="account",javaType=String.class)
	})
	@Select("<script>"+ "select osm.id as id,osm.cost as cost,osm.use_time as user_time,osm.server_ip as server_ip,osm.valid_time as valid_time,osm.os_account as os_account,osm.account account from t_osmonth osm " +
			"		<where>" + 
			"			<if test='params.osAccount != null and params.osAccount !=\"\"'>" + 
			"				and osm.os_account like concat(#{params.osAccount},'%')" + 
			"			</if>" + 
			"			<if test='params.Account != null and params.Account !=\"\"'>" + 
			"				and osm.account = #{params.Account}" + 
			"			</if>" + 
			"			<if test='params.startTime != null and params.startTime !=\"\"'>" + 
			"				and osm.use_time &gt;= #{params.startTime} " + 
			"			</if>" + 
			"			<if test='params.endTime != null and params.endTime !=\"\"'>" + 
			"				and osm.use_time &lt;= #{params.endTime} " + 
			"			</if>" + 
			"		</where> limit #{params.index},#{params.rows}" + 
	 "</script>")
	List<OsmonthBean> listOsDayQueryByParams(@Param("params")Map params);
}

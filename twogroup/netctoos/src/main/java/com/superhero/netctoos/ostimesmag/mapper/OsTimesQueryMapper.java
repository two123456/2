package com.superhero.netctoos.ostimesmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OstimesBean;

/***
 * 按月查询账务账单详情（次）mybatis映射接口
 * @author wyr
 *
 */
public interface OsTimesQueryMapper {
	/***
	 * 根据账务账号，业务账号，日期查询账务账单数量
	 * @param params
	 * @return
	 */
	@Select("<script>"+ "select count(*) from t_ostimes  " +
			"		<where>" + 
			"			<if test='params.osAccount != null and params.osAccount !=\"\"'>" + 
			"				and os_account like concat(#{params.osAccount},'%')" + 
			"			</if>" + 
			"			<if test='params.outTime != null and params.outTime !=\"\"'>" + 
			"				and out_time &lt;= #{params.endTime} " + 
			"			</if>" + 
			"			<if test='params.outTime != null and params.outTime !=\"\"'>" + 
			"				and out_time &gt;= #{params.startTime} " + 
			"			</if>" + 
			"		</where>" + 
	 "</script>")
	int countOsTimesQueryByParams(@Param("params")Map params);
	/***
	 * 根据账务账号，业务账号，日期查询账务账单
	 * @param params
	 * @return
	 */
	@Results({@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="cost",column="cost",javaType=double.class),
		@Result(property="serverIp",column="server_ip",javaType=String.class),
		@Result(property="validTime",column="valid_time",javaType=double.class),
		@Result(property="osAccount",column="os_account",javaType=String.class),
		@Result(property="enterTime",column="enter_time",javaType=Date.class),
		@Result(property="outTime",column="out_time",javaType=Date.class)
	})
	@Select("<script>"+ "select * from t_ostimes  " +
			"		<where>" + 
			"			<if test='params.osAccount != null and params.osAccount !=\"\"'>" + 
			"				and os_account like concat(#{params.osAccount},'%')" + 
			"			</if>" + 
			"			<if test='params.outTime != null and params.outTime !=\"\"'>" + 
			"				and out_time &lt;= #{params.endTime} " + 
			"			</if>" + 
			"			<if test='params.outTime != null and params.outTime !=\"\"'>" + 
			"				and out_time &gt;= #{params.startTime} " + 
			"			</if>" + 
			"		</where> limit #{params.index},#{params.rows}" + 
	 "</script>")
	List<OstimesBean> listOsTimesQueryByParams(@Param("params")Map params);
}

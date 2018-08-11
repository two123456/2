package com.superhero.netctoos.osdaymag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.OsdayBean;
/***
 * 按天查询账务账单mybatis映射接口
 * @author wyr
 *
 */
public interface OsDayQueryMapper {
	/***
	 * 根据账务账号，业务账号，日期查询账务账单数量
	 * @param params
	 * @return
	 */
	@Select("<script>"+ "select count(*) from t_osday osd left join t_os os on os.os_account=osd.os_account\r\n" + 
			"left JOIN t_account_info aci on aci.id=os.fk_account_id\r\n" + 
			"AND osd.os_account = params.osAccount" +
			"		<where>" + 
			"			<if test='params.osAccount != null and params.osAccount !=\"\"'>" + 
			"				and os_account like concat(#{params.osAccount},'%')" + 
			"			</if>" + 
			"			<if test='params.startTime != null and params.startTime !=\"\"'>" + 
			"				and use_time >= params.startTime ,'%')" + 
			"			</if>" + 
			"			<if test='params.endTime != null and params.endTime !=\"\"'>" + 
			"				and use_time >= params.endTime ,'%')" + 
			"			</if>" + 
			"		</where>" + 
	 "</script>")
	int countOsDayQueryByParams(Map params);
	/***
	 * 根据账务账号，业务账号，日期查询账务账单
	 * @param params
	 * @return
	 */
	@Results({@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="cost",column="cost",javaType=double.class),
		@Result(property="useTime",column="use_time",javaType=Date.class),
		@Result(property="serverIp",column="server_ip",javaType=String.class),
		@Result(property="validTime",column="valid_time",javaType=Date.class),
		@Result(property="osAccount",column="os_account",javaType=String.class)
	})
	@Select("<script>"+ "select osd.id as id,osd.cost as cost,osd.user_time as user_time,osd.server_ip as server_ip,osd.valid_time as valid_time,osd.os_account as os_account from t_osday osd left join t_os os on os.os_account=osd.os_account\r\n" + 
			"left JOIN t_account_info aci on aci.id=os.fk_account_id\r\n" + 
			"AND osd.os_account = params.osAccount" +
			"		<where>" + 
			"			<if test='params.osAccount != null and params.osAccount !=\"\"'>" + 
			"				and os_account like concat(#{params.osAccount},'%')" + 
			"			</if>" + 
			"			<if test='params.startTime != null and params.startTime !=\"\"'>" + 
			"				and use_time >= params.startTime ,'%')" + 
			"			</if>" + 
			"			<if test='params.endTime != null and params.endTime !=\"\"'>" + 
			"				and use_time >= params.endTime ,'%')" + 
			"			</if>" + 
			"		</where>" + 
	 "</script>")
	List<OsdayBean> listOsDayQueryByParams(Map params);
}

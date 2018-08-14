package com.superhero.netctoos.osmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.OsBean;

public interface OsMapper {
	/**
	 * 根据账务账号姓名，业务账号查询（需要连表业务账号，账务账号，服务器，资费）
	 * 
	 * @param map
	 * @return
	 */
	@Select("<script>"
			+ "SELECT aci.user_name AS useName, os.id AS id,os.os_account AS osAccount,CASE os.os_state WHEN '0' THEN '开通' when '1' THEN '暂停' WHEN '-1' THEN '停用' ELSE '申请开通' END AS osStatus,s.server_ip AS 'serverBean.serverIp',aci.account AS account,ta.tariff_name as tariff FROM t_os os ,t_account_info aci ,t_server s ,t_tariff ta " 
			+ "<where>"
			+ "os.fk_account_id=aci.id AND s.id=os.fk_server_id AND ta.id=os.fk_tariff_id "  
			+ "<if test='m.userName != null and m.userName !=\"\" '>"
			+ "and aci.user_name=#{m.userName}"
			+ "</if>" 
			+ "<if test='m.osAccont != null and m.osAccont !=\"\" '>"
			+ "and os.os_account =#{m.osAccont}" 
			+ "</if>" 
			+ "</where>"
			+ "limt m.index,m.rows" 
			+ "</script>")
	public List<OsBean> getOsBeanByItem(@Param("m") Map<String, Object> map);

	@Select("<script>"
			+ "count(*) " 
			+ "<where>"
			+ "os.fk_account_id=aci.id AND s.id=os.fk_server_id AND ta.id=os.fk_tariff_id "  
			+ "<if test='m.userName != null and m.userName !=\"\" '>"
			+ "and aci.user_name=#{m.userName}"
			+ "</if>" 
			+ "<if test='m.osAccont != null and m.osAccont !=\"\" '>"
			+ "and os.os_account =#{m.osAccont}" 
			+ "</if>" 
			+ "</where>"
			+ "</script>")
	public int getOsBeanCount(@Param("m")Map<String, Object> map);
}

package com.superhero.netctoos.serverRecordmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.bean.ServiceRecordBean;

/***
 * 服务控制mybatis映射接口·
 * 
 * @author gongtao
 *      
 */
public interface IServerRecordMapper {
	
	@Select("<script> select id as id ,os_account as osAccount,server_ip as serverIp,log_in_time as enterTime, log_out_time as outTime,valid_time as validTime from t_service_record  "
			+ "<where> <if test='params.day != null '>"
			+ "and log_out_time &gt;= #{params.day}" + "</if>" + "</where></script>")
	public List<ServiceRecordBean> listByDate(@Param("params") Map map);
}

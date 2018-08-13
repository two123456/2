package com.superhero.netctoos.servermag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.ServerBean;
/***
 * 服务器mybatis映射接口
 * @author gongtao
 *
 */
public interface ServerMapper {
	/***
	 * 统计所有服务器
	 * @return
	 */
	@Select("select count(*) from t_server")
	int countpagebean(@Param("params")Map params);
	 /***
     * 显示所有服务器
     * @param page
     * @return
     */
@Results({
	@Result(id=true,property="id",column="id",javaType=int.class),
	@Result(property="serverIp",column="server_ip",javaType=String.class),
	@Result(property="serverState",column="server_state",javaType=Integer.class)
})	
@Select("select * from t_server  limit #{params.index},#{params.rows}")
List<ServerBean>listServerByparams(@Param("params")Map params);
	
}

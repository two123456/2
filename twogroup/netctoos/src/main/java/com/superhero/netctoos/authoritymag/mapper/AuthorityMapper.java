package com.superhero.netctoos.authoritymag.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.superhero.netctoos.bean.AuthorityBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.TariffBean;
/**
 * 权限管理读取 映射接口
 * @author Administrator
 *
 */
public interface AuthorityMapper {
	/**
	 * 分页显示所有权限
	 * @param page
	 * @return
	 */
	
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="authorityName",column="authority_name",javaType=String.class)
	})
	@Select("select * from t_authority  limit #{params.index},#{params.rows}")
	List<AuthorityBean>listAuthorityByparams(@Param("params")Map params);
	
	/**
	 * 根据ID得到权限信息
	 * @param id id
	 * @return 权限信息
	 */
	@ResultType(AuthorityBean.class)
	@Select("select id as id,authority_name as authorityName"
			+ " from t_authority where id=#{id}")
	AuthorityBean getAuthorityById(Long id);
	
	/**
	 * 统计所有权限
	 * @param params
	 * @return
	 */
	@Select("select count(*) from t_authority")
	int countpage (@Param("params")Map params);
}

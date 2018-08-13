package com.superhero.netctoos.rolemag.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.AuthorityBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.RoleBean;
/**
 * 角色读取映射接口
 * @author Administrator
 *
 */
public interface RoleMapper {
	/**
	 * 分页查询显示角色信息
	 * @param page 页码
	 * @param roleName 角色名称
	 * @return 分页对象
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="roleName",column="role_name",javaType=String.class),
		@Result(property="roleType",column="role_type",javaType=int.class)
	})
	@Select("<script>"
			+ "		select id as id," + 
			"		role_name ,role_type from t_role "+
			"		<where>" + 
			"			<if test='params.roleName != null and params.roleName !=\"\"'>" + 
			"				and role_name like concat(#{params.roleName},'%')" + 
			"			</if>" + 
			"		</where>"
			+ "</script>")
	List<RoleBean>listRoleByparams(@Param("params")Map params);
	
	/**
	 * 根据ID得到角色信息
	 * @param id 角色id
	 * @return 角色信息
	 */
	@ResultType(RoleBean.class)
	@Select("select id as id,role_name as roleName,role_type as roleType"
			+ " from t_role where id=#{id}")
	RoleBean getRoleById(Long id);
	
	/**
	 * 统计所有角色
	 * @param params
	 * @return
	 */
	@Select("select count(*) from t_role")
	int countpage (@Param("params")Map params);

}

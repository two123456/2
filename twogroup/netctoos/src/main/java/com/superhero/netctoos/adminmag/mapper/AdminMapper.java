package com.superhero.netctoos.adminmag.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.bean.PageBean;
/**
 * 管理员管理读取 映射接口
 * @author Administrator
 *
 */
public interface AdminMapper {
	/**
	 * 根据id查询管理员信息
	 * @param id
	 * @return
	 */
		@ResultType(AdminBean.class)
		@Select("select id as id,real_name as adminName,admin_account as adminNum,admin_pwd as adminPwd,admin_tel as adminPhone,admin_post as adminMail from t_admin  where id = #{id}")
	public AdminBean getAdminBeanById(Long id);
	/**
	 * 按管理员姓名模糊查询
	 * @param page
	 * @param adminName
	 * @return
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="adminName",column="real_name",javaType=String.class),
		@Result(property="adminNum",column="admin_account",javaType=String.class),
		@Result(property="adminPwd",column="admin_pwd",javaType=String.class),
		@Result(property="adminPhone",column="admin_tel",javaType=String.class),
		@Result(property="adminMail",column="admin_post",javaType=String.class)
	})
	@Select("<script>"
			+ "		select id as id," + 
			"		real_name ,admin_account,admin_pwd,admin_tel,admin_post from t_admin "+
			"		<where>" + 
			"			<if test='params.adminName != null and params.adminName !=\"\"'>" + 
			"				and real_name like concat(#{params.adminName},'%')" + 
			"			</if>" + 
			"		</where> limit #{params.index},#{params.rows}"
			+ "</script>")
	List<AdminBean>listAdminByparams(@Param("params")Map params);	
	/**
	 * 统计所有角色
	 * @param params
	 * @return
	 */
	@Select("select count(*) from t_admin")
	int countpage (@Param("params")Map params);

}

package com.superhero.netctoos.tariffmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.TariffBean;
/***
 * 资费mybatis映射接口
 * @author gongtao
 *
 */
public interface TariffMapper {
	/**
	 * 根据资费id查询资费信息
	 * @param id 资费id
	 * @return 资费对象
	 */
	
	@ResultType(TariffBean.class)
	@Select("select id as id,tariff_name as tariffName,tariff_type as tariffType,time_length as timeLengh,basic_cost as basicCost,"
			+ "unit_cost as unitCost,tariff_info as tariffInfo,tariff_state as tariffState"
			+ " from t_tariff where id=#{id}")
	TariffBean getTariffById(Long id);
	
	/***
	 * 分页显示资费
	 * @param params
	 * @return
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=Integer.class),
        @Result(property="tariffName",column="tariff_name",javaType=String.class),
        @Result(property="tariffType",column="tariff_type",javaType=Integer.class),
        @Result(property="timeLengh",column="time_length",javaType=Double.class),
        @Result(property="basicCost",column="basic_cost",javaType=Double.class),
        @Result(property="unitCost",column="unit_cost",javaType=Double.class),
        @Result(property="tariffInfo",column="tariff_info",javaType=String.class),
        @Result(property="tariffState",column="tariff_state",javaType=Integer.class)
	})
	@Select("select * from t_tariff  limit #{params.index},#{params.rows}")
	List<TariffBean>listTariffByparams(@Param("params")Map params);
	/***
	 * 统计所有资费
	 * @return
	 */
	@Select("select count(*) from t_tariff")
	int countpage (@Param("params")Map params);
}

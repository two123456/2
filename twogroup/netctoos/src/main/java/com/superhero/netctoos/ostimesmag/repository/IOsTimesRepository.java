package com.superhero.netctoos.ostimesmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OstimesBean;

/***
 * 按月查询账务账单持久层（写）
 * @author wyr
 *
 */
public interface IOsTimesRepository extends JpaRepository<OstimesBean, Long>{

}

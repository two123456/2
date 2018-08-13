package com.superhero.netctoos.osmonthmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.OsmonthBean;

/***
 * 按月查询账务账单持久层（写）
 * @author wyr
 *
 */
public interface IOsMonthRepository extends JpaRepository<OsmonthBean, Long>{

}

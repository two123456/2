package com.superhero.netctoos.osdaymag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.OsdayBean;
/**
 * 按天查询账务账单持久层实现（写）
 * @author wyr
 *
 */
public interface OsDayHandleRepository extends JpaRepository<OsdayBean, Long>{

}

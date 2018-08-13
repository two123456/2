package com.superhero.netctoos.logdailymag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.LogDailyBean;
/**
 * 日志记录持久层接口
 * @author xiasuiying
 *
 */
public interface ILogDailyRepository extends JpaRepository<LogDailyBean, Long>{

	
}

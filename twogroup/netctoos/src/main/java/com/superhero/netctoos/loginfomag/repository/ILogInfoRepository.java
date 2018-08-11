package com.superhero.netctoos.loginfomag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.LogInfoBean;
/**
 * 日志内容持久层接口
 * @author xiasuiying
 *
 */
public interface ILogInfoRepository extends JpaRepository<LogInfoBean, Long>{

}

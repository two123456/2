package com.superhero.netctoos.logInmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.LogInBean;

/**
 * 登陆日志持久层接口
 * @author xiasuiying
 *
 */
public interface ILogInRepository extends JpaRepository<LogInBean, Long>{

	
}

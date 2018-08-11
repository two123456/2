package com.superhero.netctoos.testmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.UserBean;


public interface LoginRepository extends JpaRepository<UserBean, Long>{
	@DataSource("write")
	List<UserBean> findAll();
}

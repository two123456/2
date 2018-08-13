package com.superhero.netctoos.tariffmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.superhero.netctoos.bean.TariffBean;


/**
 *资费持久层接口
 * @author gongtao
 *
 */
public interface ITariffrepository extends JpaRepository<TariffBean, Long>,JpaSpecificationExecutor<TariffBean> {
	
}

package com.superhero.netctoos.accoutinfomag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.AccountInfoBean;

public interface IAccountInfoRepository extends JpaRepository<AccountInfoBean, Long>{

}

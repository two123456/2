package com.superhero.netctoos.accountbillyearmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.AccountBillBean;
import com.superhero.netctoos.bean.AccountBillYearBean;

public interface AccountBillYearRepository extends JpaRepository<AccountBillYearBean, Long>{

}

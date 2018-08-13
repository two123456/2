package com.superhero.netctoos.osyearmag.repositry;

import org.springframework.data.jpa.repository.JpaRepository;


import com.superhero.netctoos.bean.OsyearBean;

/***
 * 按年查询账务账单持久层（写）
 * @author wyr
 *
 */
public interface IOsYearRepository extends JpaRepository<OsyearBean, Long>{

}

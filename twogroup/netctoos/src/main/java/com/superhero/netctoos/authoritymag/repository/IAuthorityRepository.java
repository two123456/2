package com.superhero.netctoos.authoritymag.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.superhero.netctoos.bean.AuthorityBean;
/**
 * 权限管理写入 持久层接口
 * @author Administrator
 *
 */
public interface IAuthorityRepository extends JpaRepository<AuthorityBean, String>{

}

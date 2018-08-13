package com.superhero.netctoos.rolemag.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.superhero.netctoos.bean.RoleBean;
/**
 * 角色管理写入 持久层接口
 * @author Administrator
 *
 */
public interface IRoleRepository extends JpaRepository<RoleBean, String>{

}

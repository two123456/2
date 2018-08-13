package com.superhero.netctoos.adminmag.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.superhero.netctoos.bean.AdminBean;
/**
 * 管理员管理写入 持久层接口
 * @author Administrator
 *
 */
public interface IAdminRepository extends JpaRepository<AdminBean, String>{

}

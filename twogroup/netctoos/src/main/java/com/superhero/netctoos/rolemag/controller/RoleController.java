package com.superhero.netctoos.rolemag.controller;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.superhero.netctoos.bean.MessagerBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.RoleBean;
import com.superhero.netctoos.rolemag.handleservice.IRoleHandleService;
import com.superhero.netctoos.rolemag.queryservice.IRoleQueryService;

@RequestMapping("/role")
@Controller
public class RoleController {
   
	@Resource
	private IRoleHandleService roleHandleServiceImpl;
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IRoleQueryService roleQueryServiceImpl;
	
	@RequestMapping(value="/saveRole")
	public @ResponseBody MessagerBean saveRole(RoleBean role) {
		log.info(role);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			roleHandleServiceImpl.saveRole(role);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("RoleController----saveRole()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/updateRole")
	public @ResponseBody MessagerBean updateRole(RoleBean role) {
		log.info(role);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			roleHandleServiceImpl.updateRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("RoleController----updateRole()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/deleteRole",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public @ResponseBody MessagerBean deleteRole(Long id) {		
		log.info(id);
		RoleBean role = roleQueryServiceImpl.getRoleById(id);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			roleHandleServiceImpl.deleteRole(role);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("RoleController----deleteRole()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/showPage",produces= {"application/json;charset=utf-8"})
	public @ResponseBody PageBean showAllRloe(int page,int limit) {
		log.info(page);
		log.info(limit);
		PageBean pager = new PageBean(page,limit);
	 	Map<String,Object> map = new HashMap<>();
	 	map.put("roleName", null);		
	 	try {
	 		pager = roleQueryServiceImpl.getRole(map, pager);
		 	pager.setMsg("");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("RoleController-----------showAllRloe()",e);
		}
	 	
		return pager;
}
}

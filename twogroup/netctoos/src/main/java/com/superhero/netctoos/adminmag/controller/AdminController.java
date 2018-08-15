package com.superhero.netctoos.adminmag.controller;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.superhero.netctoos.adminmag.handleservice.IAdminHandleService;
import com.superhero.netctoos.adminmag.queryservice.IAdminQueryService;
import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.bean.MessagerBean;
import com.superhero.netctoos.bean.PageBean;

@RequestMapping("/admins")
@Controller
public class AdminController {	
	@Resource
	private IAdminHandleService  adminHandleServiceImpl;
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IAdminQueryService adminQueryServiceImpl;
	
	@RequestMapping(value="/saveAdmin",method= {RequestMethod.POST})
	public @ResponseBody MessagerBean saveAdmin(AdminBean admin) {
		log.info(admin);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			adminHandleServiceImpl.saveAdminBean(admin);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("AdminController----saveAdmin()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/updateAdmin",method= {RequestMethod.POST})
	public @ResponseBody MessagerBean updateAdmin(AdminBean admin) {
		log.info(admin);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		AdminBean admins = adminQueryServiceImpl.getAdminBeanById(admin.getId());
		admins.setAdminName(admin.getAdminName());
		admins.setAdminMail(admin.getAdminMail());
		admins.setAdminPhone(admin.getAdminPhone());
		admins.setRole(admin.getRole());
		try {
			adminHandleServiceImpl.updateAdminBean(admins);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("AdminController----updateAdmin()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/deleteAdmin",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public @ResponseBody MessagerBean deleteAdmin(Long id) {		
		log.info(id);
		System.out.println(id);
		AdminBean admin = adminQueryServiceImpl.getAdminBeanById(id);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			adminHandleServiceImpl.deleteAdminBean(admin);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("AdminController----deleteAdmin()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	@RequestMapping(value="/showPage",produces= {"application/json;charset=utf-8"})
	public @ResponseBody PageBean listPagebyAdminName(int page,int limit) {
		log.info(page);
		log.info(limit);
		PageBean pager = new PageBean(page,limit);
	 	Map<String,Object> map = new HashMap<>();
	 	map.put("adminName", null);		
	 	try {
	 		pager = adminQueryServiceImpl.getAdminBeanByName(map, pager);
		 	pager.setMsg("");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("AdminController-----------listPagebyAdminName()",e);
		}
	 	
		return pager;
}
	
	@RequestMapping(value="/findPage",produces= {"application/json;charset=utf-8"})
	public @ResponseBody PageBean listPagebyAdminName(int page,int limit,String adminName) {
			log.info(page);
			log.info(limit);
			log.info(adminName);
			System.out.println(adminName);
			PageBean pager = new PageBean(page,limit);
		 	Map<String,Object> map = new HashMap<>();
		 	map.put("adminName", adminName);		
		 	try {
		 		pager = adminQueryServiceImpl.getAdminBeanByName(map, pager);
			 	pager.setMsg("");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("AdminController-----------listPagebyAdminName()",e);
			}
			return pager;
	}
}

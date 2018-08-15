package com.superhero.netctoos.authoritymag.controller;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.superhero.netctoos.authoritymag.handleservice.IAuthorityHandleService;
import com.superhero.netctoos.authoritymag.queryservice.IAuthorityQueryService;
import com.superhero.netctoos.bean.AuthorityBean;
import com.superhero.netctoos.bean.MessagerBean;
import com.superhero.netctoos.bean.PageBean;

@RequestMapping("/authority")
@Controller
public class AuthorityController {
	
	@Resource
	private IAuthorityHandleService authorityHandleServiceImpl;
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IAuthorityQueryService authorityQueryServiceImpl;
	
	@RequestMapping(value="/saveAuthority")
	public @ResponseBody MessagerBean saveAuthority(AuthorityBean auth) {
		log.info(auth);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			authorityHandleServiceImpl.saveAuthority(auth);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("AuthorityController----saveAuthority()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/deleteAuthority",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public @ResponseBody MessagerBean deleteAuthority(Long id) {		
		log.info(id);
		AuthorityBean auth = authorityQueryServiceImpl.getAuthorityById(id);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			authorityHandleServiceImpl.deleteAuthority(auth);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("AuthorityController----deleteAuthority()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/showPage",produces= {"application/json;charset=utf-8"})
	public @ResponseBody PageBean showAllAuthority(int page,int limit) {
		log.info(page);
		log.info(limit);
		PageBean pager = new PageBean(page,limit);
	 	Map<String,Object> map = new HashMap<>();
	 	map.put("authorityName", null);		
	 	try {
	 		pager = authorityQueryServiceImpl.getAllAuthority(map, pager);
		 	pager.setMsg("");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("AuthorityController-----------showAllAuthority()",e);
		}
	 	
		return pager;
}	
}

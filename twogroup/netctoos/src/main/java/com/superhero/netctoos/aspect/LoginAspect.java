package com.superhero.netctoos.aspect;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import com.superhero.netctoos.annotation.MyLogin;
import com.superhero.netctoos.bean.LogDailyBean;
import com.superhero.netctoos.bean.LogInBean;
import com.superhero.netctoos.bean.LogInfoBean;

@Aspect
@Component
public class LoginAspect {
	@Pointcut(value="@annotation(com.superhero.netctoos.annotation.MyLogin)")
	private void pointcut() {}
	@AfterReturning(pointcut="pointcut() && @annotation(myLogin) ",returning="rev")
	public void afterReturningAdvice(JoinPoint jp,MyLogin myLogin,Object rev,HttpServletRequest request)throws Exception {
		
		
		
		//设置操作日志数据 
		String username=(String)SecurityUtils.getSubject().getPrincipal();
		String serverIp=getRemoteHost(request);
		LogInBean logIn=new LogInBean();
		logIn.setLogName(username);
		logIn.setLogTime(new Date());
		logIn.setEnter(myLogin.operateType().getType());
		logIn.setServerIp(serverIp);
		//-----------------上传MQ-----------

	}
	public String getRemoteHost(HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
}

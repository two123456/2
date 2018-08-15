package com.superhero.netctoos.aspect;

import java.sql.Date;
import java.util.Arrays;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.superhero.netctoos.annotation.MyLog;
import com.superhero.netctoos.bean.LogDailyBean;
import com.superhero.netctoos.bean.LogInfoBean;
import com.superhero.netctoos.logdailymag.handleservice.ILogdailyHandleService;



/**
 * 操作日志切面
 * @author xiasuiying
 *
 */
@Aspect
@Component
public class OperateLogAspect {

	
	@Pointcut(value="@annotation(com.superhero.netctoos.annotation.MyLog)")
	private void pointcut() {}
	
	/**
	 * 后置返回通知
	 * 该通知执行在目标方法正常执行成功之后
	 * @param jp 连接点
	 * @param rev 目标方法的返回结果
	 */
	@AfterReturning(pointcut="pointcut() && @annotation(myLog) ",returning="rev")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog,Object rev)throws Exception {
		
		
		Object[] args = jp.getArgs();
		//设置操作日志数据 
		 HttpServletRequest request = ((ServletRequestAttributes) 
				 RequestContextHolder.getRequestAttributes()).getRequest();
		 request.getAttribute("user");
		LogDailyBean log = new LogDailyBean();
		LogInfoBean logInfo=new LogInfoBean();
		
		log.setDailyName("哈哈");//??
//		log.setDailyTime(new Date());
		log.setDailyMod(myLog.menuName());//操作是哪一个模块？
		log.setDailyType(myLog.operateType().getType());//进行的什么操作？
		
		logInfo.setDailyInfo("操作模块："+myLog.menuName()+"  操作类型："+myLog.operateType().getType()+"  操作内容："+Arrays.toString(jp.getArgs()));
		log.setLogInfo(logInfo);
		
	}
		
}

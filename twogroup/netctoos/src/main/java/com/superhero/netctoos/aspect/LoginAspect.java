package com.superhero.netctoos.aspect;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.superhero.netctoos.annotation.MyLogin;
import com.superhero.netctoos.bean.LogInBean;

@Aspect
@Component
public class LoginAspect {
	
	@Pointcut(value="@annotation(com.superhero.netctoos.annotation.MyLogin)")
	private void pointcut() {}
	
	
	@AfterReturning(pointcut="pointcut() && @annotation(myLogin)",returning = "returnVal")
	public void afterReturningAdvice(JoinPoint jp,Object returnVal,MyLogin myLogin)throws Exception {
		
		
		
		//设置操作日志数据 
		String username=(String)SecurityUtils.getSubject().getPrincipal();
//		String serverIp=getRemoteHost(request);
		LogInBean logIn=new LogInBean();
		logIn.setLogName(username);
		logIn.setLogTime(new Date());
		logIn.setEnter(myLogin.operateType().getType());
		logIn.setServerIp("");
		//-----------------上传MQ-----------
		final String TOPIC_PREFIX = "topic://";
		// 定义连接信息
		String user = env("ACTIVEMQ_USER", "admin");
		String password = env("ACTIVEMQ_PASSWORD", "admin");
		String host = env("ACTIVEMQ_HOST", "127.0.0.1");
		int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));

		String connectionURI = "amqp://" + host + ":" + port;
		String destinationName = "queue://messageLogin";// 定义队列名称
//
		JmsConnectionFactory factory = new JmsConnectionFactory(connectionURI);
		Connection connection = factory.createConnection(user, password);
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = null;
		if (destinationName.startsWith(TOPIC_PREFIX)) {
			destination = session.createTopic(destinationName.substring(TOPIC_PREFIX.length()));
		} else {
			destination = session.createQueue(destinationName);
		}
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		
			ObjectMessage msg = session.createObjectMessage(logIn);
			producer.send(msg);
			
			
		

		producer.send(session.createObjectMessage("SHUTDOWN"));

		connection.close();
		System.exit(0);
	}
	private static String env(String key, String defaultValue) {
		String rc = System.getenv(key);
		if (rc == null)
			return defaultValue;
		return rc;
	
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

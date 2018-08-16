package com.superhero.netctoos.aspect;


import java.util.Arrays;
import java.util.Date;


import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;


import org.apache.qpid.jms.JmsConnectionFactory;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import com.superhero.netctoos.annotation.MyLog;
import com.superhero.netctoos.bean.LogDailyBean;
import com.superhero.netctoos.bean.LogInfoBean;




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
	@AfterReturning(pointcut="pointcut()&& @annotation(myLog)",returning="rev")
	public void afterReturningAdvice(JoinPoint jp,Object rev,MyLog myLog){
		
		
		
		 System.out.println("Taget method execute result: " + rev);  
		//设置操作日志数据 
//		String username=(String)SecurityUtils.getSubject().getPrincipal(); 
		
		LogDailyBean log = new LogDailyBean();
		LogInfoBean logInfo=new LogInfoBean();
		
		log.setDailyName("666");//
		log.setDailyTime(new Date());
		log.setDailyMod(myLog.menuName());//操作是哪一个模块？
		log.setDailyType(myLog.operateType().getType());//进行的什么操作？
		
		logInfo.setDailyInfo("操作模块："+myLog.menuName()+"  操作类型："+myLog.operateType().getType()+"  操作内容："+Arrays.toString(jp.getArgs()));
		log.setLogInfo(logInfo);
		
		//---------------上传MQ------------------
		final String TOPIC_PREFIX = "topic://";
		// 定义连接信息
		String user = env("ACTIVEMQ_USER", "admin");
		String password = env("ACTIVEMQ_PASSWORD", "admin");
		String host = env("ACTIVEMQ_HOST", "127.0.0.1");
		int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));

		String connectionURI = "amqp://" + host + ":" + port;
		String destinationName = "queue://message";// 定义队列名称
//
		JmsConnectionFactory factory = new JmsConnectionFactory(connectionURI);
		Connection connection;
		try {
			connection = factory.createConnection(user, password);
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
			ObjectMessage msg = session.createObjectMessage(log);
			producer.send(msg);
			producer.send(session.createObjectMessage("SHUTDOWN"));
			connection.close();
			
			System.exit(0);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private static String env(String key, String defaultValue) {
		String rc = System.getenv(key);
		if (rc == null)
			return defaultValue;
		return rc;
	}
}

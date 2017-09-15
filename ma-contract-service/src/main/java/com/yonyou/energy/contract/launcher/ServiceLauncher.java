package com.yonyou.energy.contract.launcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
服务加载器
 */
public class ServiceLauncher {
 	private static final String bootPath = ServiceLauncher.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLauncher.class);
	public static void main(String[] args) {
		try{
			new ClassPathXmlApplicationContext(new String[] {"spring-config.xml"});
			LOGGER.info("{}服务已启动", new Object[]{ bootPath });
		}catch(Throwable ex){
			LOGGER.error("服务已启动异常:{}", new Object[]{ ex.getLocalizedMessage(), ex });
		}
		//启动本地服务，然后hold住本地服务
		synchronized (ServiceLauncher.class) {
			while (true) {
				try {
					ServiceLauncher.class.wait();
				} catch (InterruptedException ex) {
					LOGGER.error("{}服务异常终止:{}" , new Object[]{ bootPath, ex.getMessage(), ex});
				}
			}
		}
	}

}
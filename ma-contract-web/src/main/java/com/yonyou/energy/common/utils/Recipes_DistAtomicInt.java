package com.yonyou.energy.common.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.cpu.common.utils.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用Curator实现分布式计数器
 * 
 * 为防止首次调用client.start()的性能问题，加@Controller提前加载类，static块中调用client.start()
 * 和atomicInteger.get()，用线程防止.start()和.get()阻塞主线程。
 * spring-config.xml的context:component-scan中，增加 “,org.cpu.common.utils”
 * 
 * @author hugw
 *
 */
 
public class Recipes_DistAtomicInt {
    private static final Logger logger = LoggerFactory.getLogger(Recipes_DistAtomicInt.class);

	private static final String distatomicint_path = "/curator_recipes_distatomicint_path_x";
	private static CuratorFramework client;
	private static DistributedAtomicInteger atomicInteger;

	public void init(){

		new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while(true) {
					try {
						logger.info("-------Recipes_DistAtomicInt.init.start--------------,reload {} times", i++);
						String address = PropertyUtil.getPropertyByKey("dubbo.registry.address");
						logger.info("-------Recipes_DistAtomicInt.init.start--------------,dubbo.registry.address:{}", address);

						initpost(address);
						
					} catch (Exception e) {
					}
				}
			}
		}).start();
	}
 
	 private static void initpost(String address) throws Exception{
			if (address == null || address.isEmpty()) {
				Thread.sleep(1000);
			} else {
				client = CuratorFrameworkFactory.builder().connectString(address).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
				atomicInteger = new DistributedAtomicInteger(client, distatomicint_path, new RetryNTimes(3, 1000));
				long start = System.currentTimeMillis();
				logger.info("-------Recipes_DistAtomicInt.init.start--------------,start_time:{}", start);
				try {
					logger.info("-------Recipes_DistAtomicInt.init.start--------------,client.start() before");
					client.start();
					logger.info("-------Recipes_DistAtomicInt.init.start--------------,client.start() after");
				} catch (Exception e) {
					logger.error("client.start(), Exception:{}",e.getMessage());
					 return;
				}
				try {
					logger.info("-------Recipes_DistAtomicInt.init.start--------------,atomicInteger.get() start ");
					Integer post = atomicInteger.get().postValue();
					logger.info("-------Recipes_DistAtomicInt.init.start--------------,atomicInteger.get() end ," + post.toString());
				} catch (Exception e) {
					logger.error("atomicInteger.get().postValue():{}",e.getMessage());
					return;
				}
				long end = System.currentTimeMillis();
				logger.info("-------Recipes_DistAtomicInt.init.end--------------,time(ms):" + (end - start));
			 
			}
	 }

	/**
	 * 创建一个“curator_recipes_distatomicint_path”为key的自增队列，示例代码：
	 * (建议使用“distatomicint_path_cpu_XXXX_XXXX”，防止与其他人争用同一个路径)
	 * 
	 * DistributedAtomicInteger atomicInteger = new
	 * DistributedAtomicInteger(Recipes_DistAtomicInt.getClient(),
	 * "/curator_recipes_distatomicint_path", new RetryNTimes(3, 1000));
	 * System.out.println( "Result: " + atomicInteger.get().postValue()); //
	 * 返回当前值 System.out.println( "Result: " +
	 * atomicInteger.increment().postValue() ); // 返回+1后的值
	 * 
	 * @return
	 */
	public static CuratorFramework getClient() {
		String address = PropertyUtil.getPropertyByKey("dubbo.registry.address");
		logger.info("dubbo.registry.address:{}", address);
		if(client==null){
			try {
				initpost(address);
			} catch (Exception e) {
				logger.error("getClient{}",e.getMessage());
			}
			 
		}
			
		return client;
	}

	/**
	 * 返回+1后的值 (在全局路径“curator_recipes_distatomicint_path_x”上)
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Integer increment() throws Exception {
		return atomicInteger.increment().postValue();
	}

	/**
	 * 返回当前值 (在全局路径“curator_recipes_distatomicint_path_x”上)
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Integer get() throws Exception {
		return atomicInteger.get().postValue();
	}
}
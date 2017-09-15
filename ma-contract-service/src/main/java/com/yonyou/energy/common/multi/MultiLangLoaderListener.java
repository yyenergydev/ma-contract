package com.yonyou.energy.common.multi;

import com.yonyou.iuap.context.ContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MultiLangLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextlistener init");
		initMultiLangContext(sce);
	}
	
	private void initMultiLangContext(ServletContextEvent event) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());

        ContextHolder.setContext(context);
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}

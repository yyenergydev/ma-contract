<%@ page session="false" %>
<%
org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(com.yonyou.cpu.web.portal.controller.account.SsoLoginService.class).login(request,response);
%>
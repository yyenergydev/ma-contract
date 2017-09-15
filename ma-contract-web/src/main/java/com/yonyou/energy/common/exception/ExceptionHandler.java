package com.yonyou.energy.common.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yonyou.cpu.commons.domain.reslutVo.ResultVo;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//import org.apache.commons.lang3.exception.ExceptionUtils;


/**
 * Created by caolin on 2016/9/4.
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object o, Exception ex) {
        logger.error(ExceptionUtils.getFullStackTrace(ex));
        ModelAndView mv=null;

        //response.setStatus(503);//自定义服务端异常码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
           ResultVo resultVo=new ResultVo(0);
            resultVo.setMsg(ex.getMessage());//"服务器端错误！"
            writer.write(JSON.toJSONString(resultVo, SerializerFeature.WriteMapNullValue));
           writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }


        return mv;
    }
}

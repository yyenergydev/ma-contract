package com.yonyou.energy.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yonyou.cpu.api.privilege.account.IAccountService;
import com.yonyou.cpu.api.privilege.enterprise.IEnterpriseService;
import com.yonyou.cpu.commons.domain.PageBean;
import com.yonyou.cpu.domain.criteria.enterprise.EnterpriseCriteria;
import com.yonyou.cpu.domain.entity.account.MgrUser;
import com.yonyou.cpu.domain.entity.enterprise.EnterprisePOJO;
import com.yonyou.energy.common.cache.SessionCacheManager;
import com.yonyou.energy.common.domain.reslutVo.ResultVo;
import com.yonyou.energy.common.domain.response.BaseResponseCode;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonFastUtil;
import com.yonyou.energy.common.util.JsonUtils;
import com.yonyou.iuap.context.InvocationInfoProxy;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 控制类基类
 * change by mahonggeng
 * 2017-09-12 16:07
 **/
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public SessionCacheManager baseSessionCacheManager;
    public static final String SUCCESS_FLAG = "success";
    public static final String ERROR_FLAG = "error";
    public static final String WEBRESPONSE_STATUS = "status";
    public static final String WEBRESPONSE_DATA = "data";
    public static final String WEBRESPONSE_PAGEINDEX = "pageIndex";
    public static final String WEBRESPONSE_PAGESIZE = "pageSize";
    public static final String WEBRESPONSE_TOTALPAGE = "totalPage";
    public static final String WEBRESPONSE_TOTALCOUNT = "totalCount";
    public static final String WEBRESPONSE_RESULT = "result";
    public static final String WEBRESPONSE_MSG = "msg";
    /*@Autowired
    protected IAccountService accountService;
    @Autowired
    protected IEnterpriseService enterpriseService;*/

    public BaseController() {
    }

    public void fillErrorMsg(Map<String, Object> resultMap, String filed, String reason) {
        resultMap.put("result", "0");
        resultMap.put("field", filed);
        resultMap.put("reason", reason);
    }

    /*public MgrUser getCurrentUserData() {
        MgrUser user = null;
        String ucuserid = InvocationInfoProxy.getParameter("ucuserid");

        try {
            user = (MgrUser)this.baseSessionCacheManager.getCurUser(ucuserid, MgrUser.class);
        } catch (Exception var6) {
            this.logger.error("查询用户失败!", var6);
        }

        if (user != null) {
            return user;
        } else {
            MgrUser mgrUser = new MgrUser();
            mgrUser.setUcuserid(ucuserid);
            user = this.accountService.getUserByMgrUser(mgrUser);

            try {
                this.baseSessionCacheManager.cacheUser(ucuserid, user);
            } catch (Exception var5) {
                this.logger.error("写入用户redis缓存失败!", var5);
            }

            return user;
        }
    }*/

    protected String warpResponseArray(ServiceResponse<String> response) {
        if (response == null) {
            return null;
        } else {
            JSONObject responseJson = new JSONObject();
            if (BaseResponseCode.SUCCESS.getCode().equals(response.getCode())) {
                String data = (String)response.getResult();
                if (data == null || data.isEmpty()) {
                    data = "[]";
                }

                /*JSONObject pageJson = new JSONObject();
                pageJson.put("result", data);*/
                //数组类型返回格式修改 mhg
                responseJson.put("data", data);
                responseJson.put("status", Integer.valueOf(1));
            } else {
                responseJson.put("status", Integer.valueOf(0));
                responseJson.put("msg", response.getMsg());
            }

            return responseJson.toString();
        }
    }

    /*public EnterprisePOJO getCurrentEnterprise() {
        EnterprisePOJO enterprise = null;
        String tenantId = InvocationInfoProxy.getTenantid();

        try {
            enterprise = (EnterprisePOJO)this.baseSessionCacheManager.getAttribute(tenantId, EnterprisePOJO.class);
        } catch (Exception var6) {
            this.logger.error("读取租户信息redis失败");
        }

        if (enterprise != null) {
            return enterprise;
        } else {
            try {
                EnterpriseCriteria criteria = new EnterpriseCriteria();
                criteria.setTenantid(tenantId);
                PageBean<EnterprisePOJO> enterprises = this.enterpriseService.pageQuery(0, 1, criteria);
                enterprise = (EnterprisePOJO)((List)enterprises.getResultList()).get(0);
                this.baseSessionCacheManager.putAttribute(tenantId, enterprise, 3600);
            } catch (Exception var5) {
                this.logger.error("写入用户redis缓存失败!", var5);
            }

            return enterprise;
        }
    }*/

    public void updateCurrentUser(MgrUser mgrUser) {
        MgrUser user = null;
        String ucuserid = InvocationInfoProxy.getParameter("ucuserid");

        try {
            user = (MgrUser)this.baseSessionCacheManager.getCurUser(ucuserid, MgrUser.class);
        } catch (Exception var5) {
            this.logger.error("查询用户失败!", var5);
        }

        try {
            if (user != null) {
                this.baseSessionCacheManager.disCacheUser(ucuserid);
                if (mgrUser.getEnterpriseName() == null || "" == mgrUser.getEnterpriseName()) {
                    mgrUser.setEnterpriseName(user.getEnterpriseName());
                }

                if (mgrUser.getTenantid() == null || mgrUser.getTenantid() == "") {
                    mgrUser.setTenantid(user.getTenantid());
                }
            }

            this.baseSessionCacheManager.cacheUser(ucuserid, mgrUser);
        } catch (Exception var6) {
            this.logger.error("redis缓存更新失败!", var6);
        }

    }

    protected String warpResponseList(ServiceResponse<String> response) {
        if (response == null) {
            return null;
        } else {
            JSONObject responseJson = new JSONObject();
            if (BaseResponseCode.SUCCESS.getCode().equals(response.getCode())) {
                JSONObject pageresult = (JSONObject) JsonUtils.fromJson((String)response.getResult(), JSONObject.class);
                Object data = null;
                if (pageresult != null && pageresult.get("data") != null && !pageresult.get("data").toString().isEmpty()) {
                    data = pageresult.get("data");
                } else {
                    data = "[]";
                }

                JSONObject pageJson = new JSONObject();
                pageJson.put("pageIndex", pageresult.get("pageNo"));
                pageJson.put("pageSize", pageresult.get("pageSize"));
                pageJson.put("totalPage", pageresult.get("totalPage"));
                pageJson.put("totalCount", pageresult.get("totalCount"));
                pageJson.put("result", data);
                responseJson.put("status", Integer.valueOf(1));
                responseJson.put("data", pageJson);
            } else {
                responseJson.put("status", Integer.valueOf(0));
                responseJson.put("msg", response.getMsg());
            }

            return responseJson.toString();
        }
    }

    protected String warpResponseEntity(ServiceResponse<String> response) {
        if (response == null) {
            return null;
        } else {
            JSONObject responseJson = new JSONObject();
            if (BaseResponseCode.SUCCESS.getCode().equals(response.getCode())) {
                String data = (String)response.getResult();
                if (data == null || data.isEmpty()) {
                    data = "{}";
                }

                responseJson.put("status", Integer.valueOf(1));
                responseJson.put("data", data);
            } else {
                responseJson.put("status", Integer.valueOf(0));
                responseJson.put("msg", response.getMsg());
            }

            return responseJson.toString();
        }
    }

    protected String warpResponseString(String response) {
        if (response == null) {
            return null;
        } else {
            JSONObject responseJson = new JSONObject();
            responseJson.put("status", Integer.valueOf(1));
            responseJson.put("data", response);
            return responseJson.toString();
        }
    }

    protected String warpException(Exception e) {
        JSONObject r = new JSONObject();
        r.put("status", "0");
        r.put("msg", "操作失败！");
        return r.toString();
    }

    protected String warpException(Exception e, String msg) {
        JSONObject r = new JSONObject();
        r.put("status", "0");
        r.put("msg", msg);
        return r.toString();
    }

    protected String warpResponseEntity(ServiceResponse<String> response, Class clazz) {
        if (response == null) {
            return null;
        } else {
            HashMap responseJson = new HashMap();

            try {
                if (BaseResponseCode.SUCCESS.getCode().equals(response.getCode())) {
                    String data = (String)response.getResult();
                    if (data == null || data.isEmpty()) {
                        data = "{}";
                    }

                    responseJson.put("status", Integer.valueOf(1));
                    responseJson.put("data", JsonFastUtil.fromJson(data, clazz));
                } else {
                    responseJson.put("status", Integer.valueOf(0));
                    responseJson.put("msg", response.getMsg());
                }

                return JsonFastUtil.toJson(responseJson);
            } catch (Exception var5) {
                return null;
            }
        }
    }

    protected String warpResponsePage(ServiceResponse<PageBean> response) throws Exception {
        if (response == null) {
            return null;
        } else {
            ResultVo resultVo = new ResultVo(1);
            if (response.getCode().equals(BaseResponseCode.FAILURE.getCode())) {
                resultVo.setMsg(response.getMsg());
                resultVo.setStatus(0);
            } else {
                resultVo.addData("pageIndex", ((PageBean)response.getResult()).getPageNo());
                resultVo.addData("pageSize", ((PageBean)response.getResult()).getPageSize());
                resultVo.addData("totalCount", ((PageBean)response.getResult()).getTotalCount());
                resultVo.addData("totalPage", ((PageBean)response.getResult()).getTotalPage());
                resultVo.addData("result", ((PageBean)response.getResult()).getData());
            }

            return JsonFastUtil.toJson(resultVo);
        }
    }
}

package com.yonyou.energy.contract.impl;

import com.yonyou.cpu.commons.domain.PageBean;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.BaseResponseCode;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.contract.api.IContractTypeService;
import com.yonyou.energy.contract.dao.itf.IContractTypeDAO;
import com.yonyou.energy.contract.domain.ContractType;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ContractTypeServiceImpl implements IContractTypeService {

    @Autowired
    private IContractTypeDAO contractTypeDAO;

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public ServiceResponse<String> list(BaseCriteria criteria) {
        ServiceResponse<String> response = new ServiceResponse<>();
        List result = contractTypeDAO.queryEntity(criteria);
        response.setResult(JsonUtil.collectionToString(result));
        return response;
    }

    @Override
    public ServiceResponse<String> queryByPk(Long id) {
        ServiceResponse<String> response = new ServiceResponse<>();
        ContractType contractType = contractTypeDAO.selectByPrimaryKey(id);
        response.setResult(JsonUtil.objToString(contractType));
        return response;
    }

    @Override
    public ServiceResponse<String> save(ContractType data) {
        ServiceResponse<String> result = new ServiceResponse<>();
        if(data==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("报错数据为空!");
            return result;
        }
        int count = 0;
        if(data.getId()==null || data.getId().equals(0l)){
            count = contractTypeDAO.insert(data);
        }else{
            count = contractTypeDAO.updateByPrimaryKey(data);
        }
        if(count>0){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("保存成功!");
            result.setResult(JsonUtil.objToString(data));
        }
        return result;
    }

    @Override
    public ServiceResponse<String> deleteBatch(BaseCriteria criteria) {
        return null;
    }

   /* @Override
    public ServiceResponse<PageBean> pageQuery(PageBean page, BaseCriteria criteria) {
        return null;
    }*/

    /*public ServiceResponse<PageBean> pageQuery(PageBean page, BaseCriteria criteria) {
        //返回结果
        ServiceResponse<PageBean> response = new ServiceResponse<>();

        ContractType contractType = contractTypeDAO.selectByPrimaryKey(1l);
        logger.info(contractType.toString());
        return response;
    }*/


    private Boolean checkCodeRepeat(){


        return null;
    }

    private Boolean checkCodeLength(ContractType contractType){

        return null;
    }

}

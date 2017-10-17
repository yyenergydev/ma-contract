package com.yonyou.energy.contract.impl;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.BaseResponseCode;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.common.util.JsonUtils;
import com.yonyou.energy.contract.api.IContractPuService;
import com.yonyou.energy.contract.dao.itf.IContractPuDAO;
import com.yonyou.energy.contract.domain.ContractPu;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by tanghe on 2017/10/17.
 */
@Service
public class ContractPuServiceImpl implements IContractPuService {
    
    @Autowired
    private IContractPuDAO contractPuDAO;

    @Override
    public ServiceResponse<String> list(BaseCriteria criteria) {
        ServiceResponse<String> response = new ServiceResponse<>();
        List<ContractPu> result = contractPuDAO.queryByCondition(criteria);
        response.setResult(JsonUtil.collectionToString(result));
        return response;
    }

    @Override
    public ServiceResponse<String> selectByPk(BaseCriteria criteria) {
        ServiceResponse<String> response = new ServiceResponse<>();
        ContractPu result = contractPuDAO.selectByPrimaryKey(criteria);
        response.setResult(JsonUtil.objToString(result));
        return response;
    }

    @Override
    public ServiceResponse<String> tempsave(ContractPu data, BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        if(data==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("报错数据为空!");
            return result;
        }

        //赋值一些字段
        setCommonProp(data, criteria);
        if(data.getId()==null || data.getId()==0)
            data = contractPuDAO.insertEntity(data);
        else
            data = contractPuDAO.updateEntity(data);

        //保存使用范围
        //saveContractTypeTemplate(data.getUseScopeIds(),data.getId(),data.getLevel())

        if(data!=null){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("保存成功!");
            result.setResult(JsonUtils.toJson(data));
        }
        return result;
    }

    @Override
    public ServiceResponse<String> save(ContractPu data, BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        if(data==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("报错数据为空!");
            return result;
        }
        //设置提交状态
        data.setContractStatus(1);
        if(data.getId()==null || data.getId()==0){
            //赋值一些字段
            setCommonProp(data, criteria);
            data = contractPuDAO.insertEntity(data);
        }else
            data = contractPuDAO.updateStatusById(data);

        //这里预留做提交流程的操作

        if(data!=null){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("保存成功!");
            result.setResult(JsonUtils.toJson(data));
        }
        return result;
    }

    @Override
    public ServiceResponse<String> delete(BaseCriteria criteria) {
        return null;
    }

    /**
     * 一些公共字段赋值
     */
    private void setCommonProp(ContractPu data, BaseCriteria criteria){
        String currDate = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        data.setDr(0);
        if(data.getId()==null || data.getId().equals(0l)){
            data.setCreator(1l);
            data.setCreationtime(currDate);
        }else{
            data.setModifier(1l);
            data.setModifytime(currDate);
        }
        data.setTs(currDate);
    }

    /**
     * 临时单据号生成
     * 编码规则为：年份（4）+流水号（7）例如：20170000001
     */
    private void generateBillnum(){

    }
    
}

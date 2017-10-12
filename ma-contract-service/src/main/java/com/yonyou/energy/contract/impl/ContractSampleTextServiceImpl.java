package com.yonyou.energy.contract.impl;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.BaseResponseCode;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.common.util.JsonUtils;
import com.yonyou.energy.contract.api.IContractSampleTextService;
import com.yonyou.energy.contract.dao.itf.IContractSampleTextDAO;
import com.yonyou.energy.contract.domain.ContractSampleText;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 合同示范文本服务实现类
 * @author mahonggeng
 * @create 2017-09-22 16:21
 **/
@Service
public class ContractSampleTextServiceImpl implements IContractSampleTextService {

    @Autowired
    private IContractSampleTextDAO contractSampleTextDAO;

    @Override
    public ServiceResponse<String> list(BaseCriteria criteria) {
        ServiceResponse<String> response = new ServiceResponse<>();
        if(criteria.getIds()==null && criteria.getIdstr()!=null){
            String[] str = criteria.getIdstr().split(",");
            Long[] ids = new Long[str.length];
            for(int i=0;i<str.length;i++){
                ids[i] = Long.valueOf(str[i]);
            }
            criteria.setIds(ids);
            criteria.setIdstr(null);
        }
        List result = contractSampleTextDAO.queryByCondition(criteria);
        response.setResult(JsonUtil.collectionToString(result));
        return response;
    }

    @Override
    public ServiceResponse<String> selectByPk(BaseCriteria criteria) {
        ServiceResponse<String> response = new ServiceResponse<>();
        ContractSampleText result = contractSampleTextDAO.selectByPrimaryKey(criteria);
        response.setResult(JsonUtil.objToString(result));
        return response;
    }

    @Override
    public ServiceResponse<String> save(List<ContractSampleText> data, BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        if(data==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("报错数据为空!");
            return result;
        }

        //编码校验
        List<ContractSampleText> checkValue = contractSampleTextDAO.checkCode(data);
        if(checkValue!=null && checkValue.size()>0){
            StringBuilder build = new StringBuilder(checkValue.size()*2);
            for(ContractSampleText text:checkValue){
                build.append(", ").append(text.getCode());
            }
            throw new RuntimeException(build.substring(1)+" 编码重复,请重新输入!");
        }

        List<ContractSampleText> insertList = new ArrayList<>();
        List<ContractSampleText> updateList = new ArrayList<>();
        //赋值一些字段
        setCommonProp(data, criteria, insertList, updateList);
        if(insertList.size()>0)
            insertList = contractSampleTextDAO.insertBatch(data);
        if(updateList.size()>0)
            updateList = contractSampleTextDAO.updateBatch(data);

        //保存使用范围
        //saveContractTypeTemplate(data.getUseScopeIds(),data.getId(),data.getLevel())

        if(insertList.size()>0 || updateList.size()>0){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("保存成功!");
            if(data.size()==1)
                result.setResult(JsonUtils.toJson(data.get(0)));
            else
                result.setResult(JsonUtils.toJson(data));
        }
        return result;
    }

    @Override
    public ServiceResponse<String> deleteBatch(BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        if(criteria.getId()==null && criteria.getIds()==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("请选择要删除的数据!");
            return result;
        }

        int count = contractSampleTextDAO.deleteBatch(criteria);

        if(count>0){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("删除成功!");
            //result.setResult();
        }
        return result;
    }

    /**
     * 一些公共字段赋值
     */
    private void setCommonProp(List<ContractSampleText> list, BaseCriteria criteria, List<ContractSampleText> insertList, List<ContractSampleText> updateList){
        String currDate = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        for(ContractSampleText data : list) {
            data.setDr(0);
            data.setTs(currDate);
            if (data.getId() == null || data.getId().equals(0l)) {
                data.setCreator(1l);
                data.setCreationtime(currDate);
                //需要添加当前登录人所在集团,组织

            /*data.setLevel(criteria.getLevel());
            if(criteria.getParentid()!=null && !"".equals(criteria.getParentid()))
                data.setParentId(criteria.getParentid());
            else
                data.setParentId(0l);*/
                insertList.add(data);
            } else {
                data.setModifier(1l);

                data.setModifytime(currDate);
                updateList.add(data);
            }
        }
    }
}

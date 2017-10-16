package com.yonyou.energy.contract.impl;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.BaseResponseCode;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.contract.api.IIndustryCategoryService;
import com.yonyou.energy.contract.dao.itf.IIndustryCategoryDAO;
import com.yonyou.energy.contract.domain.IndustryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by tanghe on 2017/10/12.
 */

@Service
public class IndustryCategoryServiceImpl implements IIndustryCategoryService {
    @Autowired
    private IIndustryCategoryDAO industryCategoryDAO;

    Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * 查询
     * @param criteria
     * @return
     */
    @Override
    public ServiceResponse<String> list(BaseCriteria criteria) {
        ServiceResponse<String> response = new ServiceResponse<>();
        logger.info("list 列表查询条件： " + JsonUtil.objToString(criteria));
        List result = industryCategoryDAO.queryEntity(criteria);
        response.setResult(JsonUtil.collectionToString(result));
        logger.info("list 列表查询结果： " + JsonUtil.collectionToString(result));
        return response;
    }

    /**
     * 保存
     * @param records
     * @param criteria
     * @return
     */
    @Override
    public ServiceResponse<String> save(List<IndustryCategory> records, BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        logger.info("save start");
        if (records == null) {
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("报错数据为空!");
            return result;
        }
        List<IndustryCategory> insertList = new ArrayList<IndustryCategory>();
        List<IndustryCategory> updateList = new ArrayList<IndustryCategory>();
        int count1 = 0, count2 = 0;
        for (IndustryCategory data : records) {
            if (data.getId() == null || data.getId().equals(0l)){
                //默认值
                setCommonProp(data);
                insertList.add(data);
            } else {
                data.setModifier(1l);
                updateList.add(data);
            }
        }
        if (insertList.size() > 0) {
            count1 = industryCategoryDAO.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            count2 = industryCategoryDAO.updateBatch(updateList);
        }
        if (count1 > 0 || count2 > 0) {
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("保存成功!");
            result.setResult(JsonUtil.collectionToString(records));
        }
        logger.info("save end");
        return result;
    }

    /**
     * 批量删除
     * @param criteria
     * @return
     */
    @Override
    public ServiceResponse<String> deleteBatch(BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        logger.info("deleteBatch start");
        if(criteria.getId()==null && criteria.getIds()==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("请选择要删除的数据!");
            return result;
        }
        int count = industryCategoryDAO.deleteBatch(criteria);
        if(count>0){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("删除成功!");
        }
        logger.info("deleteBatch end");
        return result;
    }

    /**
     * 一些公共字段赋值
     */
    private void setCommonProp(IndustryCategory data){
        data.setCreator(1l);
        data.setDr(0);
    }
}

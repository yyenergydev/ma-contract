package com.yonyou.energy.contract.impl;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.BaseResponseCode;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.contract.api.IContractTypeService;
import com.yonyou.energy.contract.dao.itf.IContractTypeDAO;
import com.yonyou.energy.contract.dao.itf.IContractTypeUsescopeDAO;
import com.yonyou.energy.contract.domain.ContractType;
import com.yonyou.energy.contract.domain.ContractTypeUsescope;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class ContractTypeServiceImpl implements IContractTypeService {

    @Autowired
    private IContractTypeDAO contractTypeDAO;
    @Autowired
    private IContractTypeUsescopeDAO contractTypeUsescopeDAO;

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
    public ServiceResponse<String> save(ContractType data, BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        if(data==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("报错数据为空!");
            return result;
        }
        //赋值一些字段
        setCommonProp(data, criteria);
        int count = 0;
        if(data.getId()==null || data.getId().equals(0l)){
            count = contractTypeDAO.insert(data);
        }else{
            count = contractTypeDAO.updateByPrimaryKey(data);
        }

        //保存使用范围
        saveContractTypeTemplate(data.getUseScopeIds(),data.getId(),data.getLevel());

        if(count>0){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("保存成功!");
            result.setResult(JsonUtil.objToString(data));
        }
        return result;
    }

    /**
     * 删除合同类型
     * @param criteria
     * @return
     */
    @Override
    public ServiceResponse<String> deleteBatch(BaseCriteria criteria) {
        ServiceResponse<String> result = new ServiceResponse<>();
        if(criteria.getId()==null && criteria.getIds()==null){
            result.setCode(BaseResponseCode.FAILURE.getCode());//状态 1 成功， 0 失败
            result.setMsg("请选择要删除的数据!");
            return result;
        }

        //检查是否被引用
        checkIsRef(criteria);

        int count = contractTypeDAO.deleteBatch(criteria);
        int count2 = contractTypeUsescopeDAO.deleteBatch(criteria);

        if(count>0){
            result.setCode(BaseResponseCode.SUCCESS.getCode());
            result.setMsg("删除成功!");
            //result.setResult();
        }
        return result;
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

    /**
     * 检查合同类型是否已被引用
     * @return
     */
    private Boolean checkIsRef(BaseCriteria criteria){
        if(true){

        }else{

        }
        return null;
    }

    private Boolean checkCodeRepeat(){


        return null;
    }

    private Boolean checkCodeLength(ContractType contractType){

        return null;
    }

    /**
     * 一些公共字段赋值
     */
    private void setCommonProp(ContractType data, BaseCriteria criteria){
        String currDate = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        data.setDr(0);
        if(data.getId()==null || data.getId().equals(0l)){
            data.setCreator(1l);
            data.setCreationtime(currDate);
            data.setLevel(criteria.getLevel());
            if(criteria.getParentid()!=null && !"".equals(criteria.getParentid()))
                data.setParentId(criteria.getParentid());
            else
                data.setParentId(0l);
        }else{
            data.setModifier(1l);

            data.setModifytime(currDate);
        }
        data.setTs(currDate);
    }

    /**
     * 更新会签单模板
     */
    private void saveContractTypeTemplate(String templateIds,Long contractTypeId, Integer level){
        if(templateIds==null || "".equals(templateIds))
            return ;

        List<Long> newInsert = new ArrayList<Long>();
        StringBuilder oldDelete = new StringBuilder();//子表id

        List<ContractTypeUsescope> list = contractTypeUsescopeDAO.selectByContractTypeId(contractTypeId);
        Set<Long> oldIdSet = new HashSet<Long>();
        for(ContractTypeUsescope usescope:list){
            oldIdSet.add(usescope.getOrgid());
        }
        Set<Long> newIdSet = new HashSet<Long>();
        String[] ids = templateIds.split(",");
        Long temp = null;
        for(int i=0;i<ids.length;i++){
            temp = Long.valueOf(ids[i]);
            newIdSet.add(temp);
            if(!oldIdSet.contains(temp)){
                newInsert.add(temp);
            }
        }
        for(ContractTypeUsescope l:list){
            if(!newIdSet.contains(l.getOrgid())){
                oldDelete.append(",").append(l.getId());
            }
        }
        BaseCriteria criteria = new BaseCriteria();
        criteria.setIdstr(oldDelete.substring(1));
        int delCount = contractTypeUsescopeDAO.deleteBatch(criteria);
        int insertCount = contractTypeUsescopeDAO.insertBatch(createUsescope(newInsert,contractTypeId,level));

    }

    private List<ContractTypeUsescope> createUsescope(List<Long> l, Long contractTypeId, Integer level){
        List<ContractTypeUsescope> list = new ArrayList<ContractTypeUsescope>(l.size());
        for(Long orgid : l){
            ContractTypeUsescope usescope = new ContractTypeUsescope();
            usescope.setOrgid(orgid);
            usescope.setContracttypeid(contractTypeId);
            usescope.setDr(0);
            usescope.setTs(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            if(level.intValue()>2)
                usescope.setType("group");
            else
                usescope.setType("org");
            list.add(usescope);
        }
        return list;
    }


}

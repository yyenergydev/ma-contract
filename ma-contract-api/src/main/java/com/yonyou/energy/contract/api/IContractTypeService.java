package com.yonyou.energy.contract.api;

import com.yonyou.energy.common.domain.PageBean;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.contract.domain.ContractType;

import java.util.List;

public interface IContractTypeService {

    /**
     * 列表查询
     * @param criteria
     * @return
     */
    public ServiceResponse<String> list(BaseCriteria criteria);

    public ServiceResponse<String> queryByPk(Long id);
    /**
     * 保存（新增保存，修改保存）
     * @param data
     * @return
     */
    public ServiceResponse<String> save(ContractType data, BaseCriteria criteria);

    /**
     * 删除
     * @param criteria
     * @return
     */
    public ServiceResponse<String>  deleteBatch(BaseCriteria criteria);


    /**
     * 列表查询
     * @param page
     * @param criteria
     * @return
     */
    //ServiceResponse<PageBean> pageQuery(PageBean page, BaseCriteria criteria);
}

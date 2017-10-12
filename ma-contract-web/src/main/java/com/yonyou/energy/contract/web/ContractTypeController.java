package com.yonyou.energy.contract.web;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.common.web.BaseController;
import com.yonyou.energy.contract.api.IContractTypeService;
import com.yonyou.energy.contract.domain.ContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * 合同类型REST服务
 * @author mahonggeng
 * @create 2017-09-13 16:07
 **/
@Controller
@RestController
@RequestMapping(value = "/contracttype")
public class ContractTypeController extends BaseController {

    @Autowired(required = false)
    private IContractTypeService contractTypeServiceImpl;

    @RequestMapping("/list")
    public String list(BaseCriteria criteria){

        System.out.println("Jack----------------------list--------------------------");
        Logger.getLogger(this.getClass().getName()).info("ContractType list method :"+criteria.toString());

        String result = null;
        //{"billstatus":"","billstatuses":"","code":"","enterpriseId":0,"enterpriseName":"","extFields":null,"id":0,"ids":[],"modifier":0,"name":"Jack","pageIndex":0,"pageSize":10,"parentid":0,"sortItemMap":null,"status":"","totalCount":0,"totalPage":0}
        ServiceResponse<String> response = contractTypeServiceImpl.list(criteria);
        result = this.warpResponseArray(response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContractType(@RequestBody String  jsonData, BaseCriteria criteria){

        String result = null;
        try {
            ContractType contractType = JsonUtil.jsonToObject(jsonData, ContractType.class);

            ServiceResponse<String> response = contractTypeServiceImpl.save(contractType, criteria);
            result = this.warpResponseEntity(response, ContractType.class);
        } catch (Exception e) {
            logger.error("保存失败：" + e.getMessage());
            result = this.warpException(e, e.getMessage());//"保存失败"
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteContractType(@RequestBody BaseCriteria criteria){

        System.out.println("Jack----------------------delete--------------------------");
        Logger.getLogger(this.getClass().getName()).info("ContractType delete method :"+criteria.toString());

        ServiceResponse<String> response = contractTypeServiceImpl.deleteBatch(criteria);
        String result = this.warpResponseEntity(response);
        return result;
    }
}

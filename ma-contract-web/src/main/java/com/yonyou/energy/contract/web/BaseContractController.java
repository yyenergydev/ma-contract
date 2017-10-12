package com.yonyou.energy.contract.web;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtils;
import com.yonyou.energy.common.web.BaseController;
import com.yonyou.energy.contract.api.IBaseContractService;
import com.yonyou.energy.contract.domain.BaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * 普通合同rest服务
 * @author mahonggeng
 * @create 2017-09-27 14:36
 **/
@Controller
@RestController
@RequestMapping(value = "/basecontract")
public class BaseContractController extends BaseController {
    @Autowired
    private IBaseContractService baseContractService;

    @RequestMapping(value = "/list")
    public String list(BaseCriteria criteria){

        System.out.println("Jack----------------------list--------------------------");
        Logger.getLogger(this.getClass().getName()).info("BaseContract list method :"+criteria.toString());

        String result = null;
        ServiceResponse<String> response = baseContractService.list(criteria);
        result = this.warpResponseArray(response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/queryByPk")
    public String queryByPk(BaseCriteria criteria){

        System.out.println("Jack----------------------queryByPk--------------------------");
        Logger.getLogger(this.getClass().getName()).info("BaseContract queryByPk method :"+criteria.toString());

        String result = null;
        ServiceResponse<String> response = baseContractService.selectByPk(criteria);
        result = this.warpResponseEntity(response, BaseContract.class);
        Logger.getLogger(this.getClass().getName()).info("BaseContract queryByPk method result :"+result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/tempsave", method = RequestMethod.POST)
    public String tempsave(@RequestBody String  jsonData, BaseCriteria criteria ){
        System.out.println("Jack----------------------save--------------------------");
        String result = null;
        try {
            BaseContract baseContract = JsonUtils.fromJson(jsonData, BaseContract.class);
            ServiceResponse<String> response = baseContractService.tempsave(baseContract, criteria);
            result = this.warpResponseEntity(response);
        } catch (Exception e) {
            logger.error("保存失败：" + e.getMessage());
            result = this.warpException(e, e.getMessage());//"保存失败"
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String  jsonData, BaseCriteria criteria ){
        System.out.println("Jack----------------------save--------------------------");
        String result = null;
        try {
            BaseContract baseContract = JsonUtils.fromJson(jsonData, BaseContract.class);
            ServiceResponse<String> response = baseContractService.save(baseContract, criteria);
            result = this.warpResponseEntity(response);
        } catch (Exception e) {
            logger.error("保存失败：" + e.getMessage());
            result = this.warpException(e, e.getMessage());//"保存失败"
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody BaseCriteria criteria){
        System.out.println("Jack----------------------delete--------------------------");
        Logger.getLogger(this.getClass().getName()).info("BaseContract delete method :"+criteria.toString());

        ServiceResponse<String> response = baseContractService.delete(criteria);
        String result = this.warpResponseEntity(response);
        return result;
    }

}

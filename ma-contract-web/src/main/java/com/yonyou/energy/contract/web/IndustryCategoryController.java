package com.yonyou.energy.contract.web;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.common.web.BaseController;
import com.yonyou.energy.contract.api.IIndustryCategoryService;
import com.yonyou.energy.contract.domain.IndustryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by tanghe on 2017/10/12.
 */

@Controller
@RestController
@RequestMapping(value = "/industrycategory")
public class IndustryCategoryController extends BaseController {

    @Autowired
    private IIndustryCategoryService industryCategoryService;

    @RequestMapping("/list")
    public String list(BaseCriteria criteria){
        String result = null;
        ServiceResponse<String> response = industryCategoryService.list(criteria);
        result = this.warpResponseArray(response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String jsonData, BaseCriteria criteria){
        String result = null;
        try {
            List<IndustryCategory> industryCategories = (List<IndustryCategory>) JsonUtil.jsonToObject(jsonData, IndustryCategory.class);
            ServiceResponse<String> response = industryCategoryService.save(industryCategories, criteria);
            result = this.warpResponseArray(response);
        } catch (Exception e) {
            logger.error("保存失败：" + e.getMessage());
            result = this.warpException(e, e.getMessage());//"保存失败"
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody BaseCriteria criteria){
        Logger.getLogger(this.getClass().getName()).info("industryCategory delete method :"+criteria.toString());
        ServiceResponse<String> response = industryCategoryService.deleteBatch(criteria);
        String result = this.warpResponseEntity(response);
        return result;
    }
}

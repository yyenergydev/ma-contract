package com.yonyou.energy.contract.cache;

import com.alibaba.dubbo.rpc.RpcException;
import com.yonyou.energy.common.redis.RedisClient;
import org.cpu.common.utils.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ContractCatche {

    @Resource
    RedisClient redisclient;

    private static final Logger logger = LoggerFactory.getLogger(ContractCatche.class);
    private static String CONTRACT_TYPE_KEY = "sgnc.contract_type";

    /*public Bidtrade getBidtradeById(Long bidtradeId) throws RpcException {
        Bidtrade bidtrade=new Bidtrade();
        if(bidtradeId==null){
            logger.error("BidtradeCache  getBidtradeById bidtradeId 为空" +bidtradeId);
            throw new RpcException("BidtradeCache  getBidtradeById bidtradeId 为空");
        }
        String key=bidtradekey+bidtradeId;
        if(redisclient.existKey(key)){
            String ss=redisclient.get(key);
            bidtrade= JsonUtils.fromJson(ss, Bidtrade.class);
        }else{
            bidtrade=iBidtradeDao.get(bidtradeId);
            redisclient.set(key,JsonUtils.toJson(bidtrade));
        }

        return bidtrade;
    }

    public void updateBidtrade(Bidtrade bidtrade){
        String key=bidtradekey+bidtrade.getId();
        redisclient.set(key,JsonUtils.toJson(bidtrade));
    }*/
}

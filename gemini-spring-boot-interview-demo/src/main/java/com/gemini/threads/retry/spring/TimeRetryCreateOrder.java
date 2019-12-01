package com.gemini.threads.retry.spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.retry.support.RetryTemplate;

import javax.annotation.Resource;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.retry.spring
 * @classname: timeRetryCreateOrder
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/1 16:15
 * @since 1.0.0
 */
@Slf4j
public class TimeRetryCreateOrder {

    @Resource(name = "timeoutRetryTemplate")
    private RetryTemplate timeoutRetryTemplate;

    @Resource
    private ProductRepository productRepository;

    /**
     * @param userId
     * @param productId
     * @param tradeNum
     */
    public void timeRetryCreateOrder(Long userId, int productId, int tradeNum) {
        timeoutRetryTemplate.execute((retryContext) -> {
            createOrder(userId, productId, tradeNum);
            return null;
        });
    }

    public boolean createOrder(Long userId, int productId, int tradeNum) {
        log.info("开始创建订单");
//获取产品信息
//        Product product = productRepository.getProductById(productId);
        //判断库存是否满足需要售卖的数量
//        if (product.getStock() < tradeNum) {
//            return false;
//        }
//获取最新的version信息
//        Integer version = product.getVersion();
        log.info("开始扣减库存");
//        productRepository.decreaseStock(productId, tradeNum, version);
        log.info("结束扣减库存");
        //todo 创建商品订单记录
        log.info("结束创建订单");
        return true;
    }
}

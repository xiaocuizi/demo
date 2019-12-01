package com.gemini.threads.retry.spring;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.retry.spring
 * @classname: ProductRepository
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/1 16:17
 * @since 1.0.0
 */
@Repository
public class ProductRepository {
//    @Autowired
//    private ProductMapper productMapper;
//
//    public Product getProductById(Integer id){
//        return productMapper.selectByPrimaryKey(id);
//    }
    public boolean decreaseStock(Integer productId,Integer num,Integer version) throws DBUpdateConflictException {
        // int record = productMapper.updateByProductId(productId,num,version) ;
        int record = 0;
        if(record == 0){
            throw new DBUpdateConflictException("乐观锁异常");
        }
        return true;
    }
}

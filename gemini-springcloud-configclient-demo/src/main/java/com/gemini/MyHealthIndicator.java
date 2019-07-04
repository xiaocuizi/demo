package com.gemini;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini
 * @classname: MyHealthIndicator
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 14:32
 */
public class MyHealthIndicator extends AbstractHealthIndicator {

    /**
     *
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up().withDetail("MyHealthIndicator","UP,UP,UP").build();
    }
}

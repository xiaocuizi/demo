package com.gemini.client.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaocuzi
 * @package com.gemini.client.ribbon
 * @classname: MyRule
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/1 20:59
 * @since 1.0.0
 */
public class MyRule extends AbstractLoadBalancerRule {
    /**
     * Concrete implementation should implement this method so that the configuration set via
     * {@link IClientConfig} (which in turn were set via Archaius properties) will be taken into consideration
     *
     * @param clientConfig
     */
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        Server server = null;
        ILoadBalancer loadBalancer = getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        if(allServers !=null && allServers.size() >0){

        }
        server= allServers.get(0);
        return server;
    }
}

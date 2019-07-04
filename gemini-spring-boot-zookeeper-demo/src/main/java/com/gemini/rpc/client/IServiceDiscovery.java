package com.gemini.rpc.client;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.rpc.client
 * @classname: IServiceDiscovery
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 15:40
 */
public interface IServiceDiscovery {
    String discover(String serviceName);
}

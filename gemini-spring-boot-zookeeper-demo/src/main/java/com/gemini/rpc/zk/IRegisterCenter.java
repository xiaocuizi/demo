package com.gemini.rpc.zk;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.rpc.zk
 * @classname: IRegisterCenter
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 14:48
 */
public interface IRegisterCenter {
    /**
     * 注册服务名称和服务地址
     * @param serviceName
     * @param serviceAddress
     */
    void register(String serviceName,String serviceAddress);
}



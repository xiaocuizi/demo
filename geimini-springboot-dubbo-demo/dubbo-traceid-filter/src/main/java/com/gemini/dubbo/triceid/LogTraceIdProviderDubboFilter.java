package com.gemini.dubbo.triceid;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 16:59
 */
@Activate(group = {"provider"}, order = -1)
// @Activate(group = Constants.PROVIDER)
public class LogTraceIdProviderDubboFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("xxxxxxxxxxxxxLogTraceIdProviderDubboFilterxxxxxxxxxxxxxx");
        String logTraceId = RpcContext.getContext().getAttachment(LogTraceUitls.logTraceId);
        if (StringUtils.isNotEmpty(logTraceId)) {
            MDC.put(LogTraceUitls.logTraceId, logTraceId);
        }
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (RpcException e) {
            e.printStackTrace();
        } finally {
            LogTraceUitls.removeTraceId();
        }
        return result;
    }
}

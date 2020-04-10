package com.gemini.dubbo.triceid;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 16:55
 */
@Activate(group = {"customer"}, order = -1)
// @Activate(group = Constants.CONSUMER)
public class LogTraceIdConsumerDubboFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("xxxxxxxxxxxxxLogTraceIdConsumerDubboFilterxxxxxxxxxxxxxx");
        try {
            String logTraceId = LogTraceUitls.getLogTraceId();
            if (StringUtils.isBlank(logTraceId)) {
                LogTraceUitls.addTraceId();
            }
            RpcContext.getContext().setAttachment(LogTraceUitls.logTraceId, LogTraceUitls.getLogTraceId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoker.invoke(invocation);
    }
}

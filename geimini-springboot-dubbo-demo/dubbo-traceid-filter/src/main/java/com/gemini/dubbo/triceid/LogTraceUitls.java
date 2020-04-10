package com.gemini.dubbo.triceid;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 16:48
 */
public class LogTraceUitls {
    public static final String logTraceId = "logSessionId";

    public static void addTraceId() {
        String traceId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        MDC.put(logTraceId, traceId);
    }

    public static String getLogTraceId() {
        return MDC.get(logTraceId);
    }

    public static void removeTraceId() {
        MDC.remove(logTraceId);
    }
}

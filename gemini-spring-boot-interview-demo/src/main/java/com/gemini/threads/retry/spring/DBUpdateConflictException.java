package com.gemini.threads.retry.spring;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.retry.spring
 * @classname: DBUpdateConflictException
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/1 16:22
 * @since 1.0.0
 */
public class DBUpdateConflictException extends Throwable {
    private String msg;

    public DBUpdateConflictException(String msg) {
        this.msg = msg;
    }
}

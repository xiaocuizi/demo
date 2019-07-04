package com.gemini.springboot.web.mybatisv1.executor;

import com.gemini.springboot.web.mybatisv1.entity.Test;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.configuration.executor
 * @classname: GPExecutor
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/8 16:56
 */
public interface GPExecutor {
    <T>T execute(String statement, Object parameter);
}

package com.gemini.springboot.web.mybatisv2.configuration;

import com.gemini.springboot.web.mybatisv2.MapperRegistory;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.configuration
 * @classname: GPConfiguration
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/8 16:54
 */
public class GPConfiguration {
    private String scanPath;

    private MapperRegistory mapperRegistory = new MapperRegistory();

    public GPConfiguration(String scanPath) {
        this.scanPath = scanPath;
    }


}

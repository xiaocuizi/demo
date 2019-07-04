package com.gemini.web.springv2.context;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.context
 * @classname: GMApplicationContextAware
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/23 11:28
 */
public interface GMApplicationContextAware {

    void setApplicationContext(GMApplicationContext applicationContext) throws Exception;

}

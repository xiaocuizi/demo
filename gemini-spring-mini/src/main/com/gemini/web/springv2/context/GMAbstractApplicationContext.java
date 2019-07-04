package com.gemini.web.springv2.context;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.context
 * @classname: GMAbstractApplicationContext
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/23 11:12
 */
public abstract class GMAbstractApplicationContext {

    /**
     * 提供给子类重写
     */
    protected void onRefresh() {

    }

    protected abstract void refreshBeanFactory() throws Exception;

}

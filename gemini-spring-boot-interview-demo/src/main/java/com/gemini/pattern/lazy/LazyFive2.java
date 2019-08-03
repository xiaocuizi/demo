package com.gemini.pattern.lazy;

/**
 * @author xiaocuzi
 * @package com.gemini.pattern.lazy
 * @classname: LazyFive
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/15 12:05
 * @since 1.0.0
 */
public class LazyFive2 {


    /**
     * JVM底层的逻辑
     * @return
     */
    public static final LazyFive2 getInstance() {
        return instanceHolder.instance;
    }

    private static class instanceHolder {
        private static final LazyFive2 instance = new LazyFive2();
    }

}

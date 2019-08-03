package com.gemini.pattern.lazy;

/**
 * @author xiaocuzi
 * @package com.gemini.pattern.lazy
 * @classname: LazyFive
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/15 12:05
 * @since 1.0.0
 */
public class LazyFive {

    private volatile static LazyFive instance;

    public LazyFive getInstance() {
        if (instance == null) {
            synchronized (LazyFive.class) {
                if (instance == null) {
                    return new LazyFive();
                }
            }
        }
        return null;
    }


}

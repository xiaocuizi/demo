package com.gemini;

import java.util.Optional;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini
 * @classname: OptionalDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/26 16:32
 */
public class OptionalDemo {
    public static void main(String[] args) {

        AbstractDemo abstractDemo = new AbstractDemo() {
            @Override
            public void getId(String name) {
                super.getId(name);
            }
        };
        Integer value1 = null;
        Integer value2 = new Integer(10);
        boolean integerOptional = Optional.of(value1).isPresent();
        System.out.println(integerOptional);
    }
}

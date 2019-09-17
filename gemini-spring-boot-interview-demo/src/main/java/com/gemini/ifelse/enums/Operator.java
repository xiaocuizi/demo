package com.gemini.ifelse.enums;

/**
 * @author xiaocuzi
 * @package com.gemini.ifelse.enums
 * @classname: Operator
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/17 12:41
 * @since 1.0.0
 */
public enum Operator {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    SUBTRACT {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    DIVIDE {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    },
    MODULO {
        @Override
        public int apply(int a, int b) {
            return a % b;
        }
    };

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public abstract int apply(int a, int b);
}

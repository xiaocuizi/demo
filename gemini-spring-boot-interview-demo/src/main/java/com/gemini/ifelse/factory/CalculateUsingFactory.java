package com.gemini.ifelse.factory;

/**
 * @author xiaocuzi
 * @package com.gemini.ifelse.factory
 * @classname: CalculateUsingFactory
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/17 12:28
 * @since 1.0.0
 */
public class CalculateUsingFactory {

    public static void main(String[] args) {
        int add = calculateUsingFactory(1, 2, "add");
        System.out.printf("result=%s",add);
    }

    public static int calculateUsingFactory(int a, int b, String operator) {
        Operation targetOperation = OperatorFactory
                .getOperation(operator)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return targetOperation.apply(a, b);
    }
}

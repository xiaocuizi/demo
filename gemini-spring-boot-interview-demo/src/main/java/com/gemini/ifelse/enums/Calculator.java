package com.gemini.ifelse.enums;

/**
 * @author xiaocuzi
 * @package com.gemini.ifelse.enums
 * @classname: Calculator
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/17 12:42
 * @since 1.0.0
 */
public class Calculator {
    public int calculate(int a, int b, Operator operator) {
        return operator.apply(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(3, 4, Operator.valueOf("ADD"));
        System.out.printf("result=%s", result);
    }
}

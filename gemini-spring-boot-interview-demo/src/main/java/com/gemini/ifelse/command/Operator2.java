package com.gemini.ifelse.command;

import com.gemini.ifelse.Print;
import com.gemini.ifelse.enums.Calculator;

/**
 * @author xiaocuzi
 * @package com.gemini.ifelse.command
 * @classname: Operator
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/17 12:51
 * @since 1.0.0
 */
public class Operator2 {
    public int calculate(Command command) {
        return command.execute();
    }

    public static void main(String[] args) {
        Operator2 calculator = new Operator2();
        int result = (int) calculator.calculate(new AddCommand(3, 7));
        Print.outf(result);
    }
}

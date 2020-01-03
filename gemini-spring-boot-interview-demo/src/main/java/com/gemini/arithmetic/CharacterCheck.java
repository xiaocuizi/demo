package com.gemini.arithmetic;

import java.util.Stack;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: CharacterCheck
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/13 16:28
 * @since 1.0.0
 */
public class CharacterCheck {

    public static boolean checkCharacter(String str) {

        if (str == null || str.length() == 0 || str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (stack.empty()) {
                stack.push(str.charAt(i));
            } else if ((stack.peek() == '[' && str.charAt(i) == ']')
                    || (stack.peek() == '(' && str.charAt(i) == ')')) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }

        }
        if (stack.empty()) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        boolean b = checkCharacter("([)]");
        System.out.println(b);
    }
}

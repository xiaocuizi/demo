package com.gemini.arithmetic;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: AlaboNumer
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/11/20 18:19
 * @since 1.0.0
 */
public class AlaboNumer {
    public static String a2r(int number) {
        String rNumber = "-1";
        int[] aArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};
        if (number < 1 || number > 3999) {
            return rNumber;
        }
        for (int i = 0; i < aArray.length; i++) {
            while (number >= aArray[i]) {
                rNumber += rArray[i];
                number -= aArray[i];
            }
        }
        return rNumber;
    }

    public static void main(String[] args) {
        String str = a2r(3);
        System.out.println("str=" + str);
    }
}

package com.gemini.start;

/**
 * @author xiaocuzi
 * @package com.gemini.start
 * @classname: StrTest2
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/9 14:43
 * @since 1.0.0
 */
public class StrTest2 {
    public static void main(String[] args) {
        int count = 0;
        String sourceStr = "aADSDFSFDAAA";
        String target = "A";
       /* char[] chars = sourceStr.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
          if (target ==chars[i]){
              System.out.println("7");
          }
        }*/

        count = digui(sourceStr, 'A', 0, 0);
        System.out.println("count=>" + count);

    }

    public static int digui(String str, char target, int count, int index) {
        char[] chars = str.toCharArray();
        if (target == (chars[index])) {
            count++;
        }
        System.out.println("indedx=" + index + ",count2=" + count);
        index++;
        if (index == str.length() - 1) {
            return count;
        }
        return digui(str, target, count, index);

    }
}

package com.gemini.interiew.interiew2;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew2
 * @classname: Ugly
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/19 15:41
 * @since 1.0.0
 */
public class Ugly {
    public static void main(String[] args) {
       /* int[] source = {10, 3, 12, 34, 33, 67, 14, 22, 45, 56, 23, 90, 1, 113, 114, 116, 224, 335, 61};
        Arrays.parallelSort(source);
        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                // 如果前面的是偶数、后面是奇数
                if (source[i] % 2 == 0 *//*&& source[j] % 2 != 0*//*) {
                    //if (i + 1 < source.length) {
                    int temp = source[i];
                    System.out.println("temp" + temp);
                    source[i] = source[j];
                    source[j] = temp;
                    // }
                }
            }
        }

        System.out.println("source=" + Arrays.toString(source));
        //---------------------
        int index = 12;
        int a = index % 2;
        System.out.println("a=" + a);
        System.out.println(index / 2);
        while (index % 2 == 0) {
            index /= 2;
            System.out.println("index=" + index);
        }*/
        // =========================
        System.out.println(reverseInteger(67890));
    }

    public static int reverse(int x) {
        int pre = 0;
        System.out.println(x % 10);
        System.out.println(x % 100);
        System.out.println(x % 1000);
        return 0;
    }

    public static int reverseInteger(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            System.out.println("temp=" + temp);
            x = x / 10; //不断取前几位
            System.out.println("x=" + x);
            /*if (temp / 10 != res) {
                res = 0;
                break;
            }*/
            res = temp;
        }
        return res;
    }

}

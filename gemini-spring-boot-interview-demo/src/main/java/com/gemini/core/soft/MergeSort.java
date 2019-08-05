package com.gemini.core.soft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.soft
 * @classname: MergeSort
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/6 16:53
 */
public class MergeSort {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] arry = {8, 4, 5, 7, 1, 3, 6, 2};
        //定义结果数组
        List result = new ArrayList(arry.length);

        //找出中间值
        int mid = arry[arry.length / 2];

        System.out.println(String.format("mid=%s", mid));
        System.out.println(arry.length / 2);
        //进行切分
        //int data[] = new int[3]; /*开辟了一个长度为3的数组*/
        //int left[] = new int[arry.length / 2];
        List left = new ArrayList(arry.length / 2);
        //int right[] = new int[arry.length - (arry.length / 2)];
        List right = new ArrayList(arry.length - (arry.length / 2));
        ;
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] <= mid) {
                left.add(arry[i]);
            } else {
                System.out.println(arry[i]);
                right.add(arry[i]);
            }
        }
        //左右两边进行排序
        left = smallSort(left);
        right = smallSort(right);

        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                //1 <4
                //左边和右边进行比较再加入结果队列
                if (Integer.parseInt(right.get(j) + "") < Integer.parseInt(left.get(i) + "")) {
                    result.add(right.get(j));
                }
            }
        }

        System.out.println(result.toString());

    }


    /**
     * @param arry
     * @return
     */
    public static List smallSort(List arry) {

        if (arry.size() < 2) {
            return arry;
        }
        /*int leftLeft[] = {};
        int leftRight[] = {};*/
        List leftLeft = new ArrayList();
        List leftRight = new ArrayList();
        Object leftMid = random.nextInt(arry.size());
        //进行分组
        for (int i = 0; i < arry.size(); i++) {
            if (arry.get(i).equals(leftMid)) {
                leftLeft.add(arry.get(i));
            } else {
                leftRight.add(arry.get(i));
            }
        }
        System.arraycopy(smallSort(leftRight), 0, smallSort(leftLeft), leftLeft.size(), leftRight.size());
        return leftLeft;
    }


}



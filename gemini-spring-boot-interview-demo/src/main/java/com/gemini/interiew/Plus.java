package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: Plus
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/20 10:57
 * @since 1.0.0
 */
public class Plus {

    /**
     * 示例 1：
     * <p>
     * 输入：4
     * 输出：7
     * 解释：7 = 4 * 3 / 2 + 1
     * 示例 2：
     * <p>
     * 输入：10
     * 输出：12
     * 解释：12 = 10 * 9 / 8 + 7     - 6 * 5 / 4 + 3 -    2 * 1
     *
     * @param N
     * @return
     */
    public static int clumsy(int N) {
        //return n * (n - 1) / (n - 2) + (n - 3) - clumsy(n - 4);
        int num[] = {1, 2, 2, -1};
        return N > 4 ? N + num[N % 4] : (N > 2 ? N + 3 : N);
    }

    public static void main(String[] args) {
        int clumsy = clumsy(80);
        System.out.println("clumsy=" + clumsy);
    }
}

package com.gemini.testsingleton;

/**
 * @author xiaocuzi
 * @package com.gemini.testsingleton
 * @classname: AddTest
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/20 20:48
 * @since 1.0.0
 */
public class AddTest {
    public static int add(){
        int i = 5;
        i = i +1;
        return i;
    }

    public static void main(String[] args) {
        AddTest addTest = new AddTest();
        AddTest addTest2 = new AddTest();
        System.out.println(addTest.add());
        System.out.println(addTest.add());
    }

}

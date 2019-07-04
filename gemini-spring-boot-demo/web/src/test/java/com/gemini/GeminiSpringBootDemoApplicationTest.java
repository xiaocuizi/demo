package com.gemini;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini
 * @classname: GeminiSpringBootDemoApplicationTest
 * @description: 单元测试
 * @date 2019/2/18 12:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public  class GeminiSpringBootDemoApplicationTest {

    @Test
    public  void TestOne(){
        System.out.println("hello world~~！");
    }

}
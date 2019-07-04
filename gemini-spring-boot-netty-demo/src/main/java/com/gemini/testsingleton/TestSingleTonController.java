package com.gemini.testsingleton;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @package com.gemini.testsingleton
 * @classname: TestSingleTonController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/20 20:43
 * @since 1.0.0
 */
@RestController
public class TestSingleTonController {


    @GetMapping("/test/get/key")
    public Object getKey() {
        int i = 5;
        i = i + 1;
        return i;
    }
}

package com.gemini.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.controller
 * @classname: CacheRestControlller
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/18 15:19
 */
//@RestController
@Controller
public class CacheRestController {

    @RequestMapping
    @ResponseBody
    public String helloWord() {
        return "hello ,world";
    }

    /**
     * @return
     */
    @RequestMapping("cache")
    //@OptionsMapping(name="")
    public ResponseEntity<String> index(@RequestParam(required = false, defaultValue = "false") boolean cached) {
        if (cached) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            return ResponseEntity.ok("hello wrolds!~");
        }
    }


}

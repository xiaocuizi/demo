package com.gemini.springboot.web.service.impl;

import com.gemini.springboot.web.entity.TcUser;
import com.gemini.springboot.web.service.TcUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.service.impl
 * @classname: TcUserServiceImplTest
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/6 23:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TcUserServiceImplTest {

    @Autowired
    private TcUserService tcUserService;
    @Test
    public void save() {
        System.out.println("测试插入。。。。");
        TcUser tcUser = new TcUser();
        tcUser.setAge(97);
        tcUser.setName("王老师");
        tcUserService.save(tcUser);
    }

    @Test
    public void update() {
        System.out.println("测试更新。。。。");
        TcUser tcUser = new TcUser();
        tcUser.setId(1);
        tcUser.setAge(170);
        tcUserService.update(tcUser);
    }

    @Test
    public void delete() {
    }

    @Test
    public void count() {
    }

    @Test
    public void queryById() {
        TcUser tcUser = tcUserService.queryById(1);
        System.out.println("tcUser=" + tcUser == null ? "" : tcUser.toString());
    }

    @Test
    public void queryList() {
    }

    @Test
    public void queryPage() {
    }
}
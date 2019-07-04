package com.gemini.springboot.web.mybatisv2.mapper;

import com.gemini.springboot.web.mybatisv2.entity.Test;

public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}
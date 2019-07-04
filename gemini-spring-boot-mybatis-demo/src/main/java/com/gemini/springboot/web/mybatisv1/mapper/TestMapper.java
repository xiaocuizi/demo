package com.gemini.springboot.web.mybatisv1.mapper;
import com.gemini.springboot.web.mybatisv1.entity.Test;

public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}
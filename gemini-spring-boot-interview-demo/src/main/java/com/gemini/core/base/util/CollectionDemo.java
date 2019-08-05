package com.gemini.core.base.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.base.util
 * @classname: CollectionDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/8 15:50
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        if(CollectionUtils.isNotEmpty(stringList)){  //
            System.out.println("hhhhhhhhhhhhhhhhhhhh");
        }
        EnumSet<TimeUnit> time = EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS);
    }
}



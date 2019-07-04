package com.gemini.drivenannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.drivenannotation
 * @classname: OnClassCondition2
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/23 15:27
 */
public class OnClassCondition2 implements Condition {
    /**
     *
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean matchs = false;
        System.out.println("是否匹配"+matchs);
        return false;
    }
}



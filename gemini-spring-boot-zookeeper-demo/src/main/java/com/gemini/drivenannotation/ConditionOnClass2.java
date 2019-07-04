package com.gemini.drivenannotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnClassCondition2.class)
public @interface ConditionOnClass2 {
    Class<?>[] value();
}

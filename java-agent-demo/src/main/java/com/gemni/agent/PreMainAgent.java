package com.gemni.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package PACKAGE_NAME
 * @classname: com.gemni.agent.PreMainAgent
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/16 17:21
 */
public class PreMainAgent {
    public static void premain(String agentparam, Instrumentation inst) {
        AgentBuilder.Transformer transformer = new AgentBuilder.Transformer() {

            /**
             * 指定哪些方法需要拦截
             * any()指的是所有方法
             * @param builder
             * @param typeDescription
             * @param classLoader
             * @param javaModule
             * @return
             */
            @Override
            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                // return builder.method(ElementMatchers.<MethodDescription>any()).intercept(MethodDelegation.to(MyIntercetor.class));
                return builder.method(named("sayHello")).intercept(MethodDelegation.to(MyIntercetor.class));
            }
        };
        new AgentBuilder.Default().type(ElementMatchers.nameStartsWith("com.agent"))
                .transform(transformer).installOn(inst);
        System.out.println("premain执行..........");
        System.out.println(agentparam);
    }
}



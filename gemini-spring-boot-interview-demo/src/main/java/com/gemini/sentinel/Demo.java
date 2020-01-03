package com.gemini.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.sentinel
 * @classname: Demo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/12/28 14:56
 *
 * 1、初始化规则
 * 2、根据限流规则进行限流
 *
 *
 *
 */
public class Demo {

    @SentinelResource("HelloWorld")
    public void helloWorld() {
        // 资源中的逻辑
        System.out.println("hello world");
    }
    public static void main(String[] args) {
        // 配置规则.
        initFlowRules();

        while (true) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性，自动 exit entry
            try (Entry entry = SphU.entry("HelloWorld")) {
                // 被保护的逻辑
                System.out.println("hello world");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
        }
    }

    private static void initFlowRules(){
        // 限流规则的集合
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        // 被保护的资源（方法或者接口）
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}



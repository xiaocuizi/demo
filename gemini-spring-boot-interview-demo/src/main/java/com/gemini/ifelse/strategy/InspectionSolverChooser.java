package com.gemini.ifelse.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaocuzi
 * @package com.gemini.ifelse
 * @classname: InspectionSolverChooser
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/17 11:43
 * @since 1.0.0
 */
@Component
public class InspectionSolverChooser implements ApplicationContextAware {
    private ApplicationContext context;
    private Map<String, InspectionSolver> chooseMap = new HashMap<String, InspectionSolver>();

    public InspectionSolver choose(String type) {
        return chooseMap.get(type);
    }

    @PostConstruct
    public void register() {
        Map<String, InspectionSolver> solverMap = context.getBeansOfType(InspectionSolver.class);
        for (InspectionSolver solver : solverMap.values()) {
            for (String support : solver.supports()) {
                chooseMap.put(support, solver);
            }
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

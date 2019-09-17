package com.gemini.ifelse.strategy;

import java.util.List;

/**
 * @author xiaocuzi
 * @package com.gemini.ifelse
 * @classname: InspectionSolver
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/17 11:42
 * @since 1.0.0
 */
public abstract class InspectionSolver {
    /**
     * @param orderId
     * @param userId
     */
    public abstract void solve(Long orderId, Long userId);

    /**
     * @return
     */
    public abstract String[] supports();
}

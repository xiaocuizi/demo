package com.gemini.ifelse.strategy;

import org.springframework.stereotype.Component;

/**
 * @author xiaocuzi
 * @package com.gemini.ifelse
 * @classname: ChangeWarehouseSolver
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/17 11:56
 * @since 1.0.0
 */
@Component
public class ChangeWarehouseSolver  extends InspectionSolver {

    @Override
    public void solve(Long orderId, Long userId) {
        System.out.println("订单" + orderId + "开始进行批量转仓了。。");
    }

    @Override
    public String[] supports() {
        return new String[]{InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_WAREHOUSE};
    }
}

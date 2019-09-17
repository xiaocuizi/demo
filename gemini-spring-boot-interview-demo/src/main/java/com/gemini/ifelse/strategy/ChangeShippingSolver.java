package com.gemini.ifelse.strategy;

/**
 *
 */
public class ChangeShippingSolver extends InspectionSolver {

    @Override
    public void solve(Long orderId, Long userId) {
        System.out.println("订单" + orderId + "开始进行转快递了。。");
    }

    @Override
    public String[] supports() {
        return new String[]{InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_SHIPPING};
    }
}

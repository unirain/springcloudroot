package com.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/11
 *
 *******************************************************************************/
@Service
public class OrderQueryService {

    public String queryOrderInfo(String orderId) {
        System.out.println("获取订单信息:" + orderId);
        return "return OrderInfo :" + orderId;
    }

    @SentinelResource(value = OrderController.KEY,blockHandler = "handleFlowQpsException",
            fallback = "queryOrderInfo2Fallback")
    public String queryOrderInfoV2(String orderId) {
        // 模拟接口运行时抛出代码异常
        if ("000".equals(orderId)) {
            throw new RuntimeException();
        }
        System.out.println("获取订单信息:" + orderId);
        return "return OrderInfo :" + orderId;
    }

    /**
     * 订单查询接口抛出限流或降级时的处理逻辑
     *
     * 注意: 方法参数、返回值要与原函数保持一致
     * @return
     */
    public String handleFlowQpsException(String orderId, BlockException e) {
        e.printStackTrace();
        return "handleFlowQpsException for queryOrderInfo2: " + orderId;
    }

    /**
     * 订单查询接口运行时抛出的异常提供fallback处理
     *
     * 注意: 方法参数、返回值要与原函数保持一致
     * @return
     */
    public String queryOrderInfo2Fallback(String orderId, Throwable e) {
        return "fallback queryOrderInfo2: " + orderId;
    }

}

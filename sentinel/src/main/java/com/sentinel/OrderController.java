package com.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/********************************************************************************
 *
 * Title: 
 *
 * Description: 限流-流量控制
 *    两种方式 一种是代码 方式 一种是  aop
 *
 * @author chenlm
 * create date on 2020/12/11
 *
 *******************************************************************************/
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderQueryService orderQueryService;
    public static final String KEY = "filter-key";
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    /**
     * 初始化限流配置
     */
    @PostConstruct
    public void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule1 = new FlowRule();
        rule1.setResource(KEY);
        // QPS控制在2以内
        rule1.setCount(1);
        // QPS限流
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setLimitApp("default");
        rules.add(rule1);
        FlowRuleManager.loadRules(rules);
    }

    @RequestMapping("/getOrder")
    public String queryOrder(String orderId) {
        return orderQueryService.queryOrderInfoV2(orderId);
    }

    private String sentinelFilterV1(String orderId) {
        Entry entry = null;
        String resourceName = KEY;
        try {
            // entry可以理解成入口登记
            entry = SphU.entry(resourceName);
            // 被保护的逻辑, 这里为订单查询接口
            return orderQueryService.queryOrderInfo(orderId);

        } catch (Exception e) {
            // 接口被限流的时候, 会进入到这里
            log.warn("---getOrder1接口被限流了---, exception: ", e);
            return "接口限流, 返回空";

        }finally {
            // SphU.entry(xxx) 需要与 entry.exit() 成对出现,否则会导致调用链记录异常
            if (entry != null) {
                entry.exit();
            }
        }

    }
}

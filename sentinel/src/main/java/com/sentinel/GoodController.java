package com.sentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************************
 *
 * Title: 熔断降级
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/11
 *
 *******************************************************************************/
@RestController
public class GoodController {

    @Autowired
    private GoodQueryService goodQueryService;


    @RequestMapping("/getGoods")
    public String queryGoods(String goodId) {
        return goodQueryService.queryGoodsInfo(goodId);

    }

}

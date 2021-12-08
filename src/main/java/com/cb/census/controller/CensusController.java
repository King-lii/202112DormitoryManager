package com.cb.census.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * 进行图标页面导航
 * @create 2021-12-08 1:09
 */
@Controller
@RequestMapping("census")
public class CensusController {
    /**
     * 跳转到饼状图用户地区
     * @return
     */
    @RequestMapping("userAreaState")
    public String userAreaState(){
        return "census/userAreaState";
    }

    /**
     * 跳转到年度统计
     * @return
     */
    @RequestMapping("userYearWorkOrder")
    public String userYearWorkOrder(){
        return "census/userYearWorkOrder";
    }
    /**
     * 跳转到月度统计折线图
     * @return
     */
    @RequestMapping("userMonthWorkOrder")
    public String userMonthWorkOrder(){
        return "census/userMonthWorkOrder";
    }
}

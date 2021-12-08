package com.cb.census.controller;

import com.cb.census.domain.DataEntity;
import com.cb.census.service.CensusService;
import com.cb.census.vo.DataEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lx
 * 加载图表所需所有数据
 * @create 2021-12-08 17:10
 */
@RequestMapping("censusData")
@RestController
public class AllDataController {
    @Autowired
    private CensusService censusService;

    /**
     * 获取地区所需数据
     * @return
     */
    @RequestMapping("loadAllUserAreaData")
    public List<DataEntity> loadAllUserAreaData(){
        return this.censusService.loadAllUserAreaData();
    }

    /**
     * 根据前台传参，返回对应年度工单数据
     * @return
     */
    @RequestMapping("loadAlluserYearWorkOrder")
    public Map<String,Object> loadAlluserYearWorkOrder(DataEntityVo dataEntityVo){
        List<DataEntity> entityVos =this.censusService.loadAlluserYearWorkOrder(dataEntityVo);
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> names = new ArrayList<String>();
        List<Double> values = new ArrayList<Double>();
        for (DataEntity dataEntity:entityVos) {
            names.add(dataEntity.getName());
            values.add(dataEntity.getValue());
        }
        map.put("name",names);
        map.put("value",values);
        return map;
    }
    /**
     * 根据前台传参，返回对应月度工单数据
     * @return
     */
    @RequestMapping("loadAlluserMonthWorkOrder")
    public List<Integer> loadAlluserMonthWorkOrder(DataEntityVo dataEntityVo){
        return this.censusService.loadAlluserMonthWorkOrder(dataEntityVo);
    }
}

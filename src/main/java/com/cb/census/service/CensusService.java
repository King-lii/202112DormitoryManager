package com.cb.census.service;

import com.cb.census.domain.DataEntity;
import com.cb.census.vo.DataEntityVo;

import java.util.List;

/**
 * @author lx
 * @create 2021-12-08 17:17
 */
public interface CensusService {
    /**
     * 加载用户地区图表所需所有数据
     * @return
     */
    public List<DataEntity> loadAllUserAreaData();

    /**
     * 根据前台传参，返回对应年度工单数据
     * @return
     */
    public List<DataEntity> loadAlluserYearWorkOrder(DataEntityVo dataEntityVo);
    /**
     * 根据前台传参，返回对应月度工单数据
     * @return
     */
    public List<Integer> loadAlluserMonthWorkOrder(DataEntityVo dataEntityVo);
}

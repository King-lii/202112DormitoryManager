package com.cb.census.mapper;

import com.cb.census.domain.DataEntity;

import java.util.List;

/**
 * @author lx
 * @create 2021-12-08 17:19
 */
public interface CensusMapper {
    /**
     *加载所有用户地区数据
     * @return
     */
    List<DataEntity> loadAllUserAreaData();
    /**
     * 根据前台传参，返回对应年度工单数据
     * @return
     */
    List<DataEntity> loadAlluserYearWorkOrder(DataEntity dataEntity);

    /**
     * 根据前台传参，返回对应月度工单数据
     * @param dataEntity
     * @return
     */
    List<Integer> loadAlluserMonthWorkOrder(DataEntity dataEntity);
}

package com.cb.census.service.impl;

import com.cb.census.domain.DataEntity;
import com.cb.census.mapper.CensusMapper;
import com.cb.census.service.CensusService;
import com.cb.census.vo.DataEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @create 2021-12-08 17:18
 */
@Service
public class CensusServiceImpl implements CensusService {
    @Autowired
    private CensusMapper censusMapper;
    @Override
    public List<DataEntity> loadAllUserAreaData() {
        return this.censusMapper.loadAllUserAreaData();
    }

    @Override
    public List<DataEntity> loadAlluserYearWorkOrder(DataEntityVo dataEntityVo) {
        return this.censusMapper.loadAlluserYearWorkOrder(dataEntityVo);
    }

    @Override
    public List<Integer> loadAlluserMonthWorkOrder(DataEntityVo dataEntityVo) {
        return this.censusMapper.loadAlluserMonthWorkOrder(dataEntityVo);
    }
}

package com.cb.dt.mapper;

import com.cb.dt.domain.Repair;

import java.util.List;

public interface RepairMapper {
    int deleteByPrimaryKey(Integer reid);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Integer reid);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
    //查询所有信息
    List<Repair> queryAllRepair(Repair repair);
}
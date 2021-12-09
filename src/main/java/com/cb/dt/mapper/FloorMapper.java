package com.cb.dt.mapper;

import com.cb.dt.domain.Floor;

import java.util.List;


public interface FloorMapper {
    int deleteByPrimaryKey(Integer dtid);

    int insert(Floor record);

    int insertSelective(Floor record);

    Floor selectByPrimaryKey(Integer dtid);

    int updateByPrimaryKeySelective(Floor record);

    int updateByPrimaryKey(Floor record);
    //查询所有信息
    List<Floor> queryAllFloor(Floor floor);

}
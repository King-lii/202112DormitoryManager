package com.cb.dt.mapper;

import com.cb.dt.domain.Visitor;

import java.util.List;

public interface VisitorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    List<Visitor> queryAllVisitor(Visitor visitor);
}
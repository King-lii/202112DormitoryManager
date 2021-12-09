package com.cb.dt.service.impl;

import com.cb.dt.domain.Visitor;
import com.cb.dt.mapper.VisitorMapper;
import com.cb.dt.service.VisitorService;
import com.cb.dt.vo.VisitorVo;
import com.cb.sys.utils.DataGridView;
import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 * @create 2021-12-01 16:44
 */
@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;
    @Override
    public DataGridView queryAllVisitor(VisitorVo visitorVo) {
        Page<Object> page = PageHelper.startPage(visitorVo.getPage(), visitorVo.getLimit());
        List<Visitor> visitors = this.visitorMapper.queryAllVisitor(visitorVo);
        return new DataGridView(page.getTotal(),visitors);
    }

    @Override
    public void addVisitor(VisitorVo visitorVo) {
        this.visitorMapper.insertSelective(visitorVo);
    }

    @Override
    public void updateVisitor(VisitorVo visitorVo) {
        this.visitorMapper.updateByPrimaryKeySelective(visitorVo);
    }

    @Override
    public void deleteVisitor(int id) {
        this.visitorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatchVisitor(int[] ids) {
        for (int id:ids) {
            this.deleteVisitor(id);
        }
    }
}

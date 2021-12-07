package com.cb.dt.service.impl;

import com.cb.dt.domain.Repair;
import com.cb.dt.mapper.RepairMapper;
import com.cb.dt.service.RepairService;
import com.cb.dt.vo.RepairVo;
import com.cb.sys.utils.DataGridView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @create 2021-12-06 12:48
 */
@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;
    @Override
    public DataGridView queryAllRepair(RepairVo repairVo) {
        Page<Object> page = PageHelper.startPage(repairVo.getPage(),repairVo.getLimit());
        List<Repair> data = this.repairMapper.queryAllRepair(repairVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addRepair(RepairVo repairVo) {
        this.repairMapper.insertSelective(repairVo);
    }

    @Override
    public void cancelRepair(RepairVo repairVo) {
        this.repairMapper.updateByPrimaryKeySelective(repairVo);
    }

    @Override
    public DataGridView queryDtnameRepair(RepairVo repairVo) {
        Page<Object> page = PageHelper.startPage(repairVo.getPage(),repairVo.getLimit());
        List<Repair> data = this.repairMapper.queryDtnameRepair(repairVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public int queryManagerById(int userid) {
        return this.repairMapper.queryManagerById(userid);
    }
}

package com.cb.dt.service;

import com.cb.dt.vo.FloorVo;
import com.cb.dt.vo.RepairVo;
import com.cb.sys.utils.DataGridView;

/**
 * @author lx
 * @create 2021-12-06 12:47
 */
public interface RepairService {
    /**
     * 查询所有维修
     */
    public DataGridView queryAllRepair(RepairVo repairVo);
    /**
     * 添加维修
     */
    public void addRepair(RepairVo repairVo);
}

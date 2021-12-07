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
     * 维修上报——查询所有维修
     */
    public DataGridView queryAllRepair(RepairVo repairVo);
    /**
     * 维修上报——添加维修
     */
    public void addRepair(RepairVo repairVo);

    /**
     * 更改状态：1待处理，2处理中，3已完成，4未完成，5已取消，
     * @param repairVo
     */
    public void cancelRepair(RepairVo repairVo);

    /**
     * 维修处理——查询当前维修师傅所有维修记录
     */
    public DataGridView queryDtnameRepair(RepairVo repairVo);

    /**
     * 维修完成——查询当前维修师傅的2处理中，3已完成，4未完成
     */
    public DataGridView queryFunishRepair(RepairVo repairVo);
    /**
     * 维修记录管理——查询当前维修师傅的3已完成工单
     */
    public DataGridView queryLogRepair(RepairVo repairVo);
    /**
     * 查询当前用户是否为超级管理员
     * @param userid
     * @return
     */
    public int queryManagerById(int userid);

    /**
     * 维修记录管理——根据dtid删除宿舍
     * @param id
     */
    public void deleteRepair(int id);
    /**
     * 维修记录管理——批量删除宿舍
     * @param ids
     */
    public void deleteBatchRepair(int[] ids);
}

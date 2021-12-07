package com.cb.dt.controller;

import com.cb.dt.domain.Repair;
import com.cb.dt.service.RepairService;
import com.cb.dt.vo.FloorVo;
import com.cb.dt.vo.RepairVo;
import com.cb.sys.constast.SysConstast;
import com.cb.sys.domain.User;
import com.cb.sys.utils.AppFileUtils;
import com.cb.sys.utils.DataGridView;
import com.cb.sys.utils.ResultObj;
import com.cb.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lx
 * @create 2021-12-06 13:02
 */
@RestController
@RequestMapping("repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    /**
     * 维修上报——加载维修列表
     * @param repairVo
     * @return
     */
    @RequestMapping("loadAllRepair")
    public DataGridView loadAllRepair(RepairVo repairVo) {
        //通过session获取当前user对象
        User user = (User)WebUtils.getHttpSession().getAttribute("user");
        //repairService.queryManagerById(user.getUserid())==1判断是否为超级管理员,超级管理员查看全部数据
        if (repairService.queryManagerById(user.getUserid())==1){
            return this.repairService.queryAllRepair(repairVo);
        }else {
            //非管理员根据uid查询自己的维修记录
            repairVo.setUid(user.getUserid());
            return this.repairService.queryAllRepair(repairVo);
        }
    }

    /**
     * 维修上报——维修上报功能
     * @param repairVo
     * @return
     */
    @RequestMapping("addRepair")
    public ResultObj addRepair(RepairVo repairVo){
        //通过session获取当前user对象
        User user = (User)WebUtils.getHttpSession().getAttribute("user");
        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!repairVo.getReimg().equals(SysConstast.DEFAULT_REPAIR_IMG)) {
                String filePath= AppFileUtils.updateFileName(repairVo.getReimg(),SysConstast.FILE_UPLOAD_TEMP);
                repairVo.setReimg(filePath);
            }
            repairVo.setRetime(new Date());//将当前时间插入数据库
            //通过session注入当前用户id
            repairVo.setUid(user.getUserid());

            this.repairService.addRepair(repairVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 维修上报——取消上报
     * @param repairVo
     * @return
     */
    @RequestMapping("cancelRepair")
    public ResultObj cancelRepair(RepairVo repairVo) {
        try {
            this.repairService.cancelRepair(repairVo);
            return ResultObj.CANCEL_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.CANCEL_ERROR;
        }
    }


    /**
     * 维修处理——加载所有维修员处理数据，以及没有人处理的数据
     * @param repairVo
     * @return
     */
    @RequestMapping("loadAllResolveRepair")
    public DataGridView loadAllResolveRepair(RepairVo repairVo) {
        //通过session获取当前user对象
        User user = (User)WebUtils.getHttpSession().getAttribute("user");
        //queryManagerById查询出结果则为超级管理员可以显示所有数据，否则根据责任人名字查询
        if (repairService.queryManagerById(user.getUserid())==1){
            return this.repairService.queryAllRepair(repairVo);
        }else{
            repairVo.setReduty(user.getRealname());
            return this.repairService.queryDtnameRepair(repairVo);
        }
    }
    /**
     * 维修处理——接受当前状态工单并将责任人付给他
     * @param repairVo
     * @return
     */
    @RequestMapping("acceptRepair")
    public ResultObj acceptRepair(RepairVo repairVo){
        try {
            User user = (User)WebUtils.getHttpSession().getAttribute("user");
            repairVo.setReduty(user.getRealname());
            this.repairService.cancelRepair(repairVo);
            return ResultObj.CANCEL_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.CANCEL_ERROR;
        }
    }

    /**
     * 维修完成——查询当前维修师傅的2处理中，3已完成，4未完成
     * @param repairVo
     * @return
     */
    @RequestMapping("loadAllFunishRepair")
    public DataGridView loadAllFunishRepair(RepairVo repairVo) {
        //通过session获取当前user对象
        User user = (User)WebUtils.getHttpSession().getAttribute("user");
        //queryManagerById查询出结果则为超级管理员可以显示所有数据，否则根据责任人名字查询
        if (repairService.queryManagerById(user.getUserid())==1){
            return this.repairService.queryAllRepair(repairVo);
        }else{
            repairVo.setReduty(user.getRealname());
            return this.repairService.queryFunishRepair(repairVo);
        }
    }

    /**
     * 维修记录管理——查询当前维修师傅的3已完成工单
     * @param repairVo
     * @return
     */
    @RequestMapping("loadAllLogRepair")
    public DataGridView loadAllLogRepair(RepairVo repairVo) {
        //通过session获取当前user对象
        User user = (User)WebUtils.getHttpSession().getAttribute("user");
        //queryManagerById查询出结果则为超级管理员可以显示所有数据，否则根据责任人名字查询
        if (repairService.queryManagerById(user.getUserid())==1){
            return this.repairService.queryAllRepair(repairVo);
        }else{
            repairVo.setReduty(user.getRealname());
            return this.repairService.queryFunishRepair(repairVo);
        }
    }

    /**
     * 维修记录管理——删除维修记录
     */
    @RequestMapping("deleteRepair")
    public ResultObj deleteRepair(RepairVo repairVo) {
        try {
            this.repairService.deleteRepair(repairVo.getReid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 维修记录管理——批量删除维修记录
     */
    @RequestMapping("deleteBatchRepair")
    public ResultObj deleteBatchRepair(RepairVo repairVo) {
        try {
            this.repairService.deleteBatchRepair(repairVo.getReids());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

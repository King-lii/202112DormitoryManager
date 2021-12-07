package com.cb.dt.controller;

import com.cb.dt.domain.Repair;
import com.cb.dt.service.RepairService;
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
     * 加载维修列表
     * @param repairVo
     * @return
     */
    @RequestMapping("loadAllRepair")
    public DataGridView loadAllRepair(RepairVo repairVo) {
        User user = (User)WebUtils.getHttpSession().getAttribute("user");
        //queryManagerById查询出结果则为超级管理员可以显示所有数据，否则根据责任人名字查询
        if (repairService.queryManagerById(user.getUserid())==1){
            return this.repairService.queryAllRepair(repairVo);
        }else{
            repairVo.setReduty(user.getRealname());
            return this.repairService.queryDtnameRepair(repairVo);
        }
    }
    @RequestMapping("addRepair")
    public ResultObj addRepair(RepairVo repairVo){
        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!repairVo.getReimg().equals(SysConstast.DEFAULT_REPAIR_IMG)) {
                String filePath= AppFileUtils.updateFileName(repairVo.getReimg(),SysConstast.FILE_UPLOAD_TEMP);
                repairVo.setReimg(filePath);
            }
            repairVo.setRetime(new Date());//将当前时间插入数据库
            this.repairService.addRepair(repairVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

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
     * 接受当前状态工单并将责任人付给他
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
}

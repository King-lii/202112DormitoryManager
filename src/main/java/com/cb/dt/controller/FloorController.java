package com.cb.dt.controller;

import com.cb.dt.domain.Floor;
import com.cb.dt.service.FloorService;
import com.cb.dt.vo.FloorVo;
import com.cb.sys.constast.SysConstast;
import com.cb.sys.utils.AppFileUtils;
import com.cb.sys.utils.DataGridView;
import com.cb.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lx
 * @create 2021-12-03 21:54
 */
@RestController
@RequestMapping("floor")
public class FloorController {
    @Autowired
    private FloorService floorService;

    /**
     *加载楼层列表返回DataGridView
     */
    @RequestMapping("loadAllFloor")
    public DataGridView loadAllCar(FloorVo floorVo) {
    return this.floorService.queryAllFloor(floorVo);
}

    /**
     * 添加宿舍
     */
    @RequestMapping("addFloor")
    public ResultObj addFloor(FloorVo floorVo) {
        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!floorVo.getDtimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
                String filePath= AppFileUtils.updateFileName(floorVo.getDtimg(),SysConstast.FILE_UPLOAD_TEMP);
                floorVo.setDtimg(filePath);
            }
            this.floorService.addFloor(floorVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改车辆
     */
    @RequestMapping("updateFloor")
    public ResultObj updateFloor(FloorVo floorVo) {
        try {
            String carimg = floorVo.getDtimg();
            if(carimg.endsWith(SysConstast.FILE_UPLOAD_TEMP)) {
                String filePath=AppFileUtils.updateFileName(floorVo.getDtimg(),SysConstast.FILE_UPLOAD_TEMP);
                floorVo.setDtimg(filePath);
                //把原来的删除
                Floor floor=this.floorService.queryFloorByFloorid(floorVo.getDtid());
                AppFileUtils.removeFileByPath(floor.getDtimg());
            }
            this.floorService.updateFloor(floorVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除宿舍
     */
    @RequestMapping("deleteFloor")
    public ResultObj deleteFloor(FloorVo floorVo) {
        try {
            this.floorService.deleteFloor(floorVo.getDtid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除宿舍
     */
    @RequestMapping("deleteBatchFloor")
    public ResultObj deleteBatchFloor(FloorVo floorVo) {
        try {
            this.floorService.deleteBatchFloor(floorVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

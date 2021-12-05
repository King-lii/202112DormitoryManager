package com.cb.dt.service.impl;

import com.cb.dt.domain.Floor;
import com.cb.dt.mapper.FloorMapper;
import com.cb.dt.service.FloorService;
import com.cb.dt.vo.FloorVo;
import com.cb.sys.constast.SysConstast;
import com.cb.sys.utils.AppFileUtils;
import com.cb.sys.utils.DataGridView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @create 2021-12-03 21:47
 */
@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorMapper floorMapper;

    @Override
    public DataGridView queryAllFloor(FloorVo floorVo) {
        Page<Object> page= PageHelper.startPage(floorVo.getPage(), floorVo.getLimit());
        List<Floor> data = this.floorMapper.queryAllFloor(floorVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addFloor(FloorVo FloorVo) {
        this.floorMapper.insertSelective(FloorVo);
    }

    @Override
    public void updateFloor(FloorVo FloorVo) {
        this.floorMapper.updateByPrimaryKeySelective(FloorVo);
    }

    @Override
    public void deleteFloor(int id) {
        //先删除图片
        Floor floor = this.floorMapper.selectByPrimaryKey(id);
        //如果不是默认图片就删除
        if (!floor.getDtimg().equals(SysConstast.DEFAULT_CAR_IMG)){
            AppFileUtils.deleteFileUsePath(floor.getDtimg());
        }
        //删除数据库数据
        this.floorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatchFloor(int[] ids) {
        for (int id:ids) {
            this.deleteFloor(id);
        }
    }

    @Override
    public Floor queryFloorByFloorid(int dtid) {
        return this.floorMapper.selectByPrimaryKey(dtid);
    }
}

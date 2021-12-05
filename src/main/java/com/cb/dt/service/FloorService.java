package com.cb.dt.service;

import com.cb.dt.domain.Floor;
import com.cb.dt.vo.FloorVo;
import com.cb.sys.utils.DataGridView;

        /**
         * @author lx
         * @create 2021-12-03 21:46
         */
        public interface FloorService {
        /**
         * 查询所有宿舍
         */
        public DataGridView queryAllFloor(FloorVo floorVo);
        /**
         * 添加宿舍
         * @param FloorVo
         */
        public void addFloor(FloorVo FloorVo);
        /**
         * 修改宿舍
         * @param FloorVo
         */
        public void updateFloor(FloorVo FloorVo);
        /**
         * 根据dtid删除宿舍
         * @param id
         */
        public void deleteFloor(int id);
        /**
         * 批量删除宿舍
         * @param ids
         */
        public void deleteBatchFloor(int[] ids);

            /**
             * 根据dtid查询
             * @param dtid
             * @return
             */
            public Floor queryFloorByFloorid(int dtid);
}

package com.cb.dt.controller;

import com.cb.dt.service.VisitorService;
import com.cb.dt.vo.VisitorVo;
import com.cb.sys.utils.DataGridView;
import com.cb.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 客户管理控制器
 * @author lx
 *
 */
@RestController
@RequestMapping("visitor")
public class VisitorController {

	@Autowired
	private VisitorService visitorService;

	/**
	 * 加载客户列表返回DataGridView
	 */
	@RequestMapping("loadAllVisitor")
	public DataGridView loadAllVisitor(VisitorVo visitorVo) {
		return this.visitorService.queryAllVisitor(visitorVo);
	}
	
	/**
	 * 添加访问者
	 */
	@RequestMapping("addVisitor")
	public ResultObj addVisitor(VisitorVo visitorVo) {
		try {
			this.visitorService.addVisitor(visitorVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/**
	 * 修改访问者
	 */
	@RequestMapping("updateVisitor")
	public ResultObj updateVisitor(VisitorVo visitorVo) {
		try {
			System.out.println(visitorVo.toString());
			this.visitorService.updateVisitor(visitorVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

	/**
	 * 删除访问者
	 */
	@RequestMapping("deleteVisitor")
	public ResultObj deleteVisitor(VisitorVo visitorVo) {
		try {
			this.visitorService.deleteVisitor(visitorVo.getId());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}

	/**
	 * 批量删除拜访者
	 */
	@RequestMapping("deleteBatchVisitor")
	public ResultObj deleteBatchVisitor(VisitorVo visitorVo) {
		try {
			this.visitorService.deleteBatchVisitor(visitorVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
}

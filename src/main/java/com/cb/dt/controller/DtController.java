package com.cb.dt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 业务管理的路由控制器
 * @author lx
 *
 */
@Controller
@RequestMapping("dt")
public class DtController {

	/**
	 * 跳转到学生管理的页面
	 */
	@RequestMapping("customerManager")
	public String toCustomerManager() {
		return "business/customer/customerManager";
	}

	/**
	 * 跳转到访问管理的页面
	 */
	@RequestMapping("visitorManager")
	public String toVisitorManager() {
		return "business/visitor/visitorManager";
	}

	/**
	 * 跳转到宿舍管理的页面
	 */
	@RequestMapping("floorManager")
	public String toFloorManager() {
		return "business/floor/floorManager";
	}
	

	/**
	 * 跳转到宿舍维修
	 */
	@RequestMapping("repairManager")
	public String toRepairManager() {
		return "business/repair/repairManager";
	}
	
	/**
	 * 跳转到维修处理界面
	 */
	@RequestMapping("repairResolveManager")
	public String toRentManager() {
		return "business/repair/repairResolveManager";
	}
	
	/**
	 * 跳转到维修完成的页面
	 */
	@RequestMapping("repairFunishManager")
	public String toCheckCarManager() {
		return "business/repair/repairFunishManager";
	}
	
	/**
	 * 跳转到检查单管理的页面
	 */
	@RequestMapping("toCheckManager")
	public String toCheckManager() {
		return "business/check/checkManager";
	}
}

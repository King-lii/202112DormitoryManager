package com.cb.dt.service;

import com.cb.dt.vo.VisitorVo;
import com.cb.sys.utils.DataGridView;

/**
 * 客户管理的服务接口
 * @author lx
 *
 */
public interface VisitorService {
	/**
	 * 查询所有客户
	 * @param visitorVo
	 * @return
	 */
	public DataGridView queryAllVisitor(VisitorVo visitorVo);
	/**
	 * 添加拜访者
	 * @param visitorVo
	 */
	public void addVisitor(VisitorVo visitorVo);
	/**
	 * 修改访问者
	 * @param visitorVo
	 */
	public void updateVisitor(VisitorVo visitorVo);
	/**
	 * 根据id删除访问者
	 * @param id
	 */
	public void deleteVisitor(int id);
	/**
	 * 批量删除访问者
	 * @param ids
	 */
	public void deleteBatchVisitor(int[] ids);
//
//	/**
//	 * 根据身份证号查询客户信息
//	 * @param identity
//	 * @return
//	 */
//	public Customer queryCustomerByIdentity(String identity);


}

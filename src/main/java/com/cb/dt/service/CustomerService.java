package com.cb.dt.service;

import com.cb.dt.domain.Customer;
import com.cb.dt.vo.CustomerVo;
import com.cb.sys.utils.DataGridView;

/**
 * 客户管理的服务接口
 * @author lx
 *
 */
public interface CustomerService {
	/**
	 * 查询所有客户
	 * @param customerVo
	 * @return
	 */
	public DataGridView queryAllCustomer(CustomerVo customerVo);
	/**
	 * 添加客户
	 * @param customerVo
	 */
	public void addCustomer(CustomerVo customerVo);
	/**
	 * 修改客户
	 * @param customerVo
	 */
	public void updateCustomer(CustomerVo customerVo);
	/**
	 * 根据identity删除客户
	 * @param identity
	 */
	public void deleteCustomer(String identity);
	/**
	 * 批量删除客户
	 * @param identitys
	 */
	public void deleteBatchCustomer(String[] identitys);
	
	/**
	 * 根据身份证号查询客户信息
	 * @param identity
	 * @return
	 */
	public Customer queryCustomerByIdentity(String identity);

}

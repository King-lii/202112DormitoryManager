package com.cb.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cb.sys.domain.Menu;
import com.cb.sys.mapper.MenuMapper;
import com.cb.sys.service.MenuService;
import com.cb.sys.utils.DataGridView;
import com.cb.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
	
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> queryAllMenuForList(MenuVo menuVo) {
		return menuMapper.queryAllMenu(menuVo);
	}

	/**
	 * 用户登录关联角色菜单
	 * @param menuVo
	 * @param userId
	 * @return
	 */
	@Override
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
		return menuMapper.queryMenuByUid(menuVo.getAvailable(),userId);
	}

	@Override
	public DataGridView queryAllMenu(MenuVo menuVo) {
		Page<Object> page=PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
		List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addMenu(MenuVo menuVo) {
		this.menuMapper.insertSelective(menuVo);
	}

	@Override
	public void updateMenu(MenuVo menuVo) {
		this.menuMapper.updateByPrimaryKeySelective(menuVo);
	}

	@Override
	public Integer queryMenuByPid(Integer pid) {
		return this.menuMapper.queryMenuByPid(pid);
	}

	@Override
	public void deleteMenu(MenuVo menuVo) {
		
		//删除菜单表的数据
		this.menuMapper.deleteByPrimaryKey(menuVo.getId());
		
		//根据菜单id删除sys_role_menu里面的数据
		this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
	}

}

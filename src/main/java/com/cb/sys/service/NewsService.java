package com.cb.sys.service;

import com.cb.sys.domain.News;
import com.cb.sys.utils.DataGridView;
import com.cb.sys.vo.NewsVo;

/**
 * 公告管理的服务接口
 * @author lx
 *
 */
public interface NewsService {
	/**
	 * 查询所有公告
	 * @param newsVo
	 * @return
	 */
	public DataGridView queryAllNews(NewsVo newsVo);
	/**
	 * 添加公告
	 * @param newsVo
	 */
	public void addNews(NewsVo newsVo);
	/**
	 * 修改公告
	 * @param newsVo
	 */
	public void updateNews(NewsVo newsVo);
	/**
	 * 根据id删除公告
	 * @param newsid
	 */
	public void deleteNews(Integer newsid);
	/**
	 * 批量删除公告
	 * @param ids
	 */
	public void deleteBatchNews(Integer[] ids);
	
	/**
	 * 查询一个公告
	 * @param id
	 * @return
	 */
	public News queryNewsById(Integer id);

}

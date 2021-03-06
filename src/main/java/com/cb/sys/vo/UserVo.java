package com.cb.sys.vo;

import com.cb.sys.domain.User;

public class UserVo extends User {

	/**
	 * 分页参数
	 */
	private Integer page;
	private Integer limit;
	
	private String code;

	private String newpassword;
	// 接收多个角色id
	private Integer[] ids;

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}

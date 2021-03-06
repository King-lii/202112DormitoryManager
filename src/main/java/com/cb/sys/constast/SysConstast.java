package com.cb.sys.constast;

/**
 * 常量接口
 * @author lx
 *
 */
public interface SysConstast {

	String USER_LOGIN_ERROR_MSG = "用户名或密码不正确";
	String USER_UPDPWD_MSG ="旧密码错误";
	String LOGIN_CHECKCODE_ERROR_PASS="验证码错误";
	/**
	 * 可用状态
	 */
	Integer AVAILABLE_TRUE = 1;
	Integer AVAILABLE_FALSE = 0;
	
	/**
	 * 用户类型
	 */
	Integer USER_TYPE_SUPER = 1;
	Integer USER_TYPE_NORMAL= 2;
	
	/**
	 * 菜单是否展开
	 */
	Integer SPREAD_TRUE = 1;
	Integer SPREAD_FALSE = 0;
	
	
	/**
	 * 操作状态
	 */
	String ADD_SUCCESS="添加成功";
	String ADD_ERROR="添加失败";
	
	String UPDATE_SUCCESS="更新成功";
	String UPDATE_ERROR="更新失败";

	String CANCEL_SUCCESS="取消成功";
	String CANCEL_ERROR="取消失败";

	String DELETE_SUCCESS="删除成功";
	String DELETE_ERROR="删除失败";
	
	String RESET_SUCCESS="重置成功";
	String RESET_ERROR="重置失败";
	
	String DISPATCH_SUCCESS="分配成功";
	String DISPATCH_ERROR="分配失败";
	
	Integer CODE_SUCCESS=0; //操作成功
	Integer CODE_ERROR=-1;//失败
	
	
	/**
	 * 公用常量
	 */
	Integer CODE_ZERO = 0;
	Integer CODE_ONE = 1;
	Integer CODE_TWO = 2;
	Integer CODE_THREE = 3;
	
	/**
	 * 默认密码配置
	 */
	String USER_DEFAULT_PWD = "123456";
	/**
	 * 临时文件标记
	 */
	String FILE_UPLOAD_TEMP = "_temp";
	/**
	 * 默认图片地址
	 */
	Object DEFAULT_CAR_IMG = "images/defaultimage.jpg";
	Object DEFAULT_REPAIR_IMG = "images/defaultrepairimage.jpg";

}

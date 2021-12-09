package com.cb.sys.mapper;

import com.cb.sys.domain.User;
import com.cb.sys.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 实现登录
     */
    User login(User user);
    /**
     * 查询用户
     */
    List<User> queryAllUser(User user);
    /**
     * 保存用户和角色的关系
     * @param userid
     * @param rid
     */
    void insertUserRole(@Param("uid")Integer userid, @Param("rid")Integer rid) ;

    /**
     * 根据前台传参用户密码，查询旧密码是否正确
     * @return
     */
    int judgeUser(User user);
}
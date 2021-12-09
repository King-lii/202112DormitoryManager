package com.cb.sys.service.impl;

import com.cb.sys.constast.SysConstast;
import com.cb.sys.domain.Role;
import com.cb.sys.domain.User;
import com.cb.sys.mapper.RoleMapper;
import com.cb.sys.mapper.UserMapper;
import com.cb.sys.service.UserService;
import com.cb.sys.utils.DataGridView;
import com.cb.sys.utils.WebUtils;
import com.cb.sys.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lx
 * @create 2021-11-29 18:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User login(UserVo userVo) {
        //生成密文再进行登录判断
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        return userMapper.login(userVo);
    }
    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
        List<User> data = this.userMapper.queryAllUser(userVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addUser(UserVo userVo) {
        // 设置默认密码
        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
        // 设置用户类型 都是普通用户type=2
        userVo.setType(SysConstast.USER_TYPE_NORMAL);
        this.userMapper.insertSelective(userVo);

    }

    @Override
    public void updateUser(UserVo userVo) {
        //将台传输密码进行加密再传入数据库
        this.userMapper.updateByPrimaryKeySelective(userVo);
    }

    /**
     * 判断密码是否正确
     * @return
     */
    @Override
    public int judgeUser(UserVo userVo) {
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        userVo.setUserid(user.getUserid());
        userVo.setPwd(DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes()));
         //将密码加密再进行判断
        return this.userMapper.judgeUser(userVo);
    }

    @Override
    public void deleteUser(Integer userid) {
        // 删除用户
        this.userMapper.deleteByPrimaryKey(userid);
        // 根据用户id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByUid(userid);
    }

    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer uid : ids) {
            this.deleteUser(uid);
        }
    }

    @Override
    public void resetUserPwd(Integer userid) {
        User user = new User();
        user.setUserid(userid);
        // 设置默认密码
        user.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
        //更新
        this.userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public DataGridView queryUserRole(Integer userid) {
        //1,查询所有可用的角色
        Role role=new Role();
        role.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Role> allRole=this.roleMapper.queryAllRole(role);
        //2,根据用户ID查询已拥有的角色
        List<Role> userRole=this.roleMapper.queryRoleByUid(SysConstast.AVAILABLE_TRUE,userid);

        List<Map<String,Object>> data=new ArrayList<>();
        for (Role r1 : allRole) {
            Boolean LAY_CHECKED=false;
            for (Role r2 : userRole) {
                if(r1.getRoleid()==r2.getRoleid()) {
                    LAY_CHECKED=true;
                }
            }
            Map<String, Object> map=new HashMap<String, Object>();

            map.put("roleid", r1.getRoleid());
            map.put("rolename", r1.getRolename());
            map.put("roledesc", r1.getRoledesc());
            map.put("LAY_CHECKED", LAY_CHECKED);
            data.add(map);
        }
        return new DataGridView(data);
    }

    @Override
    public void saveUserRole(UserVo userVo) {
        Integer userid = userVo.getUserid();
        Integer[] roleIds = userVo.getIds();
        //根据用户id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByUid(userid);
        //保存关系
        if(roleIds!=null&& roleIds.length>0) {
            for (Integer rid : roleIds) {
                this.userMapper.insertUserRole(userid,rid);
            }
        }
    }
}

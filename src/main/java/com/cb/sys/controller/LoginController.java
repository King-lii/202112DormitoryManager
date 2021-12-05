package com.cb.sys.controller;

import com.cb.sys.constast.SysConstast;
import com.cb.sys.domain.LogInfo;
import com.cb.sys.domain.User;
import com.cb.sys.service.LogInfoService;
import com.cb.sys.service.UserService;
import com.cb.sys.utils.WebUtils;
import com.cb.sys.vo.LogInfoVo;
import com.cb.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 用户登录控制器
 * @author lx
 * @create 2021-11-29 18:58
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private LogInfoService logInfoService;
    /**
     * 跳转到登录页面
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        //springmvc中已经添加了前缀/WEB-INF/view/，以及后缀jsp所以此处只需要中间部分地址
        return "system/main/login";
    }
    /**
     * 登录方法
     */
    @RequestMapping("login")
    public String login(UserVo userVo, Model model){
        User user = this.userService.login(userVo);
        if (user != null){
            //放入session
            WebUtils.getHttpSession().setAttribute("user",user);

            //记录登录日志,向sys_login_log里面插入数据
            LogInfoVo logInfoVo = new LogInfoVo();
            logInfoVo.setLogintime(new Date());
            logInfoVo.setLoginname(user.getRealname()+"-"+user.getLoginname());
            logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
            logInfoService.addLogInfo(logInfoVo);

            return "system/main/index";
        }else {
            model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
            return "system/main/login";
        }
    }
}

package com.cb.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.cb.sys.constast.SysConstast;
import com.cb.sys.domain.LogInfo;
import com.cb.sys.domain.User;
import com.cb.sys.service.LogInfoService;
import com.cb.sys.service.UserService;
import com.cb.sys.utils.ResultObj;
import com.cb.sys.utils.WebUtils;
import com.cb.sys.vo.LogInfoVo;
import com.cb.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

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
        //获得存储在session中的验证码
        String code = (String) WebUtils.getHttpSession().getAttribute("code");
        //判断验证码是否正确
        if (userVo.getCode().equals(code)){
            //验证码正确进行登录判断。
            User user = this.userService.login(userVo);
            if (user != null){
                //放入session,后续查询需要使用到该数据
                WebUtils.getHttpSession().setAttribute("user",user);

                //记录登录日志,向sys_login_log里面插入数据
                LogInfoVo logInfoVo = new LogInfoVo();
                logInfoVo.setLogintime(new Date());
                logInfoVo.setLoginname(user.getRealname()+"-"+user.getLoginname());
                logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
                logInfoService.addLogInfo(logInfoVo);
                return "system/main/index";
            }else {
                //密码错误返回错误信息
                model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        }else {
            //登陆失败，提示验证码不正确！
            model.addAttribute("error", SysConstast.LOGIN_CHECKCODE_ERROR_PASS);
            return "system/main/login";
        }
    }

    /**
     * 将验证码返回给前台，并存入session
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //HuTool定义图形验证码的长和宽,验证码的位数，干扰线的条数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 35,4,5);
        //将验证码放入session
        session.setAttribute("code",lineCaptcha.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(),"JPEG",outputStream);
    }
    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    private String outLogout(){
        Enumeration em = WebUtils.getHttpSession().getAttributeNames();
        while (em.hasMoreElements()){
            WebUtils.getHttpSession().removeAttribute(em.nextElement().toString());
        }
        return "system/main/login";
    }
}

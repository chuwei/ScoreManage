package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.result.ResultFactory;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
public class LoginController {
    @Resource
    UserService userService;

//    @CrossOrigin
//    @PostMapping(value = "api/login")
//    @ResponseBody
//    public ResponseResult login(@RequestBody User requestUser, HttpSession session){
//        // 对 html 标签进行转义，防止 XSS 攻击
//        String username = requestUser.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//        String password = requestUser.getPassword();
//
//        User user = userService.getUser(username,password);
//        if (null==user) {
//            String message = "用户名或密码错误";
//            return ResultFactory.buildFailResult(message);
//        } else {
//            session.setAttribute("user", user);
//        }
//        return ResultFactory.buildSuccessResult(user);
//    }

    @PostMapping(value = "/api/login")
    @ResponseBody
    public ResponseResult login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        Boolean rememberme = requestUser.getRememberme();
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(rememberme);
        String message;
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (UnknownAccountException  e) {
            message = "用户名或密码错误";
            return ResultFactory.buildFailResult(message);
        } catch (IncorrectCredentialsException e) {
            message = "用户名或密码错误";
            return ResultFactory.buildFailResult(message);
        }  catch (ExcessiveAttemptsException e) {
            message = "登录失败次数过多";
            return ResultFactory.buildFailResult(message);
        } catch (LockedAccountException e) {
            message = "帐号已被锁定";
            return ResultFactory.buildFailResult(message);
        } catch (DisabledAccountException e) {
            message = "该帐号已被禁用.";
            return ResultFactory.buildFailResult(message);
        } catch (AuthenticationException e) {
            message = "账号异常，登录失败.";
            return ResultFactory.buildFailResult(message);
        }
    }

    @ResponseBody
    @GetMapping(value = "/api/authentication")
    public String authentication(){
        return "身份认证成功";
    }

    @ResponseBody
    @GetMapping("/api/logout")
    public ResponseResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }

}

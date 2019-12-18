package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.Result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.Result.ResultFactory;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


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
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (AuthenticationException e) {
            String message = "用户名或密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }

    @ResponseBody
    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }

}

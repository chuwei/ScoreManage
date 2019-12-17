package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.Result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.Result.ResultFactory;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Resource
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public ResponseResult login(@RequestBody User requestUser, HttpSession session){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();

        User user = userService.getUser(username,password);
        if (null==user) {
            String message = "用户名或密码错误";
            return ResultFactory.buildFailResult(message);
        } else {
            session.setAttribute("user", user);
        }
        return ResultFactory.buildSuccessResult(user);
    }
}

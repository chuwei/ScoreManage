package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.entity.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.Objects;

@Controller
public class LoginController {
    @Resource
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public ResponseResult login(@RequestBody User requestUser) throws Exception{
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();

        int code = 500;
        String message = "系统繁忙，请稍后再试";
        ResponseResult result = new ResponseResult(code,message);

        if (userService.validatePassword(username,password)) {
            result.setCode(200);
            result.setMessage("success");
        } else {
            result.setCode(400);
            result.setMessage("用户名或密码错误");
        }
        return result;
    }
}

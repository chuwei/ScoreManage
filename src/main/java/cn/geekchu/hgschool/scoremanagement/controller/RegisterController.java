package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.result.ResultFactory;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

@Controller
public class RegisterController {
    @Resource
    UserService userService;

    @PostMapping("api/register")
    @ResponseBody
    public ResponseResult register(@RequestBody User user) {
        User regUser = userService.register(user);
        return ResultFactory.buildSuccessResult(regUser);
    }
}

package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.Result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.Result.ResultFactory;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;

@Controller
public class RegisterController {
    @Resource
    UserService userService;

    @PostMapping("api/register")
    @ResponseBody
    public ResponseResult register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐,默认长度 16 位
        String salt =user.getMobile().isEmpty()?user.getMobile():"18605818616";
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }
}

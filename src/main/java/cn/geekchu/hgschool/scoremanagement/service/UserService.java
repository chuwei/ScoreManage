package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.common.constant.ServiceErrCode;
import cn.geekchu.hgschool.scoremanagement.common.exception.ServiceException;
import cn.geekchu.hgschool.scoremanagement.dao.UserRepository;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import cn.geekchu.hgschool.scoremanagement.utils.DateUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public boolean isExist(String username) {
        User user = userRepository.findByUsername(username);
        return null!=user;
    }

    public boolean validatePassword(String username, String password) {
        User user = getUser(username, password);
        return null!=user;
    }

    public User getByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public User getUser(String username, String password){
        return userRepository.getByUsernameAndPassword(username, password);
    }

    public void add(User user){
        try {
            userRepository.save(user);
        } catch (Exception e){
            throw new ServiceException(e.getMessage(), ServiceErrCode.NOTFOUND_RESULT_ERR);
        }
    }

    public User register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String mobile = user.getMobile();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            throw new ServiceException(message, ServiceErrCode.REQ_PARAM_ERR);
        }

        // 生成盐,默认长度 16 位
        String salt =mobile.isEmpty()?mobile:"18605818616";
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setPassword(encodedPassword);
        user.setStatus(true);
        user.setCreateTime(DateUtils.date2LocalDateTime(new Date()));
        add(user);
        return user;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

}

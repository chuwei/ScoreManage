package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.UserRepository;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public boolean isExist(String username) {
        User user = userRepository.findByUsername(username);;
        return null!=user;
    }

    public boolean validatePassword(String username, String password) {
        User user = getUser(username, password);
        return null!=user;
    }

    public User getUser(String username, String password){
        return userRepository.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userRepository.save(user);
    }

}

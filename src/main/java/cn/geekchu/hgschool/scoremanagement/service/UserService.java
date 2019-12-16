package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.UserRepository;
import cn.geekchu.hgschool.scoremanagement.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public boolean validatePassword(String username, String password){
        User user = userRepository.findUserByUsername(username);
        if(password.equals(user.getPassword())){
            return true;
        }else{
            return  false;
        }
    }
}

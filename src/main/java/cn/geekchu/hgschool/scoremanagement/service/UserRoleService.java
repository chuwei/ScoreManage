package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.UserRepository;
import cn.geekchu.hgschool.scoremanagement.dao.UserRoleRepository;
import cn.geekchu.hgschool.scoremanagement.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleService {
    @Resource
    UserRoleRepository userRoleRepository;

    public List<UserRole> listAllByUid(int uid){
        return userRoleRepository.findByUserid(uid);
    }

}

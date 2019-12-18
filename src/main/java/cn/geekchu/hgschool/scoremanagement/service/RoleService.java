package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.RoleRepository;
import cn.geekchu.hgschool.scoremanagement.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {
    @Resource
    RoleRepository roleRepository;

    public Role findById(Integer roleid){
        return roleRepository.findById(roleid);
    }
}

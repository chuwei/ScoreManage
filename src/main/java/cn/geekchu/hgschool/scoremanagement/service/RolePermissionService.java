package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.RolePermissionRepository;
import cn.geekchu.hgschool.scoremanagement.entity.RolePermission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolePermissionService {
    @Resource
    RolePermissionRepository rolePermissionRepository;

    public List<RolePermission> findByRoleid(Integer roleid ){
        return  rolePermissionRepository.findByRoleid(roleid);
    }
}

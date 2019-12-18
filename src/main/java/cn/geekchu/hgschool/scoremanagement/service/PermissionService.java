package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.PermissionRepository;
import cn.geekchu.hgschool.scoremanagement.entity.Permission;
import cn.geekchu.hgschool.scoremanagement.entity.Role;
import cn.geekchu.hgschool.scoremanagement.entity.RolePermission;
import cn.geekchu.hgschool.scoremanagement.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionService {
    @Resource
    PermissionRepository permissionRepository;
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    RoleService roleService;
    @Resource
    RolePermissionService rolePermissionService;

    public Set<String> listPermissionURLsByUser(String username) {
        int userid =  userService.getByUserName(username).getId();
        List<Role> roles = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();
        Set<String> URLs = new HashSet<>();

        List<UserRole> urs = userRoleService.listAllByUid(userid);
        for (UserRole ur: urs) {
            roles.add(roleService.findById(ur.getRoleid()));
        }

        for (Role role : roles) {
            List<RolePermission> rps = rolePermissionService.findByRoleid(role.getId());
            for (RolePermission rp : rps) {
                URLs.add(permissionRepository.findById(rp.getPermissionid()).getUrl());
            }
        }
        return URLs;
    }
    public boolean needFilter(String requestAPI) {
        List<Permission> ps = permissionRepository.findAll();
        for (Permission p: ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }
}

package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.Permission;

import java.util.List;

public interface PermissionRepository extends  BaseRepository<Permission> {
    Permission findById(Integer id);
}

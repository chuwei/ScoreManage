package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.RolePermission;
import java.util.List;

public interface RolePermissionRepository extends BaseRepository<RolePermission>{
    List<RolePermission> findByRoleid(Integer roleid);
}

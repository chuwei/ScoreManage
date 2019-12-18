package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.Role;

public interface RoleRepository extends  BaseRepository<Role> {
    Role findById(int roleid);
}

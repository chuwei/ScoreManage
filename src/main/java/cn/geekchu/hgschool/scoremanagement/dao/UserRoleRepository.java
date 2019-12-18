package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.UserRole;

import java.util.List;

public interface UserRoleRepository extends BaseRepository<UserRole> {
    List<UserRole> findByUserid(int userid);
}

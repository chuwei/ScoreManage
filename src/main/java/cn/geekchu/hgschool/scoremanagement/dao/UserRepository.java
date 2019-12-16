package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends  BaseRepository<User> {
    public User findUserByUsername(String username);
}

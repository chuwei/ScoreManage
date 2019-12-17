package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.User;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepository extends  BaseRepository<User> {

    @Query("select a from User a where a.username=:username and a.deleted = 0 and a.status =1")
    User findByUsername(String username);

    @Query("select a from User a where a.username=:username and a.password=:password and a.deleted = 0 and a.status =1")
    User getByUsernameAndPassword(String username, String password);

    User getById(Integer id);
}

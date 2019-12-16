package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends BaseRepository<Student>{

    @Override
    @Query("select a from Student a where a.deleted = 0")
    Page<Student> findAll(Pageable pageable);

    @Query("select a from Student a where a.name like CONCAT('%',:name,'%') and a.deleted = 0")
    Page<Student> findStudentByNameLike(String name, Pageable pageable);

    @Query("select a from Student a where a.name like CONCAT('%',:name,'%') and a.number = :number " +
            "and a.classid = :classid and a.deleted = 0")
    Page<Student> findStudentByCondition(String number,String name,Integer classid,Pageable pageable);
}

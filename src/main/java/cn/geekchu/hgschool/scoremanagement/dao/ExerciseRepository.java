package cn.geekchu.hgschool.scoremanagement.dao;

import cn.geekchu.hgschool.scoremanagement.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
}

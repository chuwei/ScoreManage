package cn.geekchu.hgschool.scoremanagement;

import cn.geekchu.hgschool.scoremanagement.entity.Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Exercise.class)
public class ExerciseTests {

    @Autowired
    Exercise exercise;
    @Test
    public void exerciseTest(){
        exercise.setName("高二下1209物理单元测验");
        System.out.println(exercise.toString());
        Assert.assertEquals(exercise.getName(),"高二下1209物理单元测验");
    }

}

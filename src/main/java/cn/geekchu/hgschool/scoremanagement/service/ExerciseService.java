package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.ExerciseRepository;
import cn.geekchu.hgschool.scoremanagement.entity.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercise(int page, int size) {
        List<Exercise> exerciseList=new ArrayList<>();
        if(page==0 || size==0){
            exerciseList = exerciseRepository.findAll();
        }else{
            Pageable pageable = PageRequest.of(page,size);
            exerciseList=exerciseRepository.findAll(pageable).getContent();
        }
        return  exerciseList;
    }

    public List<Exercise> getExerciseBy(int page, int size) {
        List<Exercise> exerciseList=new ArrayList<>();
        if(page==0 || size==0){
            exerciseList = exerciseRepository.findAll();
        }else{
            Pageable pageable = PageRequest.of(page,size);
            exerciseList=exerciseRepository.findAll(pageable).getContent();
        }
        return  exerciseList;
    }

}

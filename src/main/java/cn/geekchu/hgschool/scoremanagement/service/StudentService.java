package cn.geekchu.hgschool.scoremanagement.service;

import cn.geekchu.hgschool.scoremanagement.dao.StudentRepository;
import cn.geekchu.hgschool.scoremanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;

    public Page<Student> getStudentList(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Student> studentList=studentRepository.findAll(pageable);
        return  studentList;
    }

    public Page<Student> findStudentByCondition(Student student, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Student> studentList;
        if (null==student){
            System.out.println("student is null");
            studentList = getStudentList(page,size);
        }else{
            String number =student.getNumber();
            String name = student.getName();
            Integer classid = student.getClassid();
            if(classid != 0 ){
                if(!number.isEmpty()){

                }
            }else{

            }
            studentList=studentRepository.findStudentByCondition(number,name,classid,pageable);
        }
        return  studentList;
    }


    public Page<Student> findStudentByNameLike(String name, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return studentRepository.findStudentByNameLike(name, pageable);
    }

}

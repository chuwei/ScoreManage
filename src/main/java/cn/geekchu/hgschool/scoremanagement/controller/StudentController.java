package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.entity.Student;
import cn.geekchu.hgschool.scoremanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(value = "/studentList", produces = {"application/json;charset=UTF-8"})
    public Page<Student> getStudent (@RequestParam int page, @RequestParam int size) {
        Page<Student> students = studentService.getStudentList(0,10);
        return students;
    }

//    @RequestMapping(value = "/studentList")
//    public String getStudentList (Model model,
//                                  @RequestParam(value = "page", defaultValue = "0") int page,
//                                  @RequestParam(value = "size", defaultValue = "20") int size){
//        Page<Student> studentList = studentService.getStudentList(page,size);
//        Student queryCondition = new Student();
//        if(model.getAttribute("queryCondition")!=null){
//            queryCondition=(Student) model.getAttribute("queryCondition");
//        }
//        model.addAttribute("studentList", studentList);
//        model.addAttribute("queryCondition", queryCondition);
//        return "student/list";
//    }
    @RequestMapping("/studentList")
    public String studentQuery(Model model){
        Student queryCondition=new Student();
        model.addAttribute("queryCondition",queryCondition);
        return "student/list";
    }

    @RequestMapping("/studentQuery")
    public String studentQuery( @ModelAttribute Student student,
                                Model model,
                                @RequestParam(value = "page", defaultValue = "0") int page,
                                @RequestParam(value = "size", defaultValue = "20") int size) {
        Page<Student> studentList = studentService.findStudentByCondition(student,page,size);
        model.addAttribute("studentList", studentList);
        model.addAttribute("queryCondition", student);
        return "student/list";
    }
}

package cn.geekchu.hgschool.scoremanagement.controller;

import cn.geekchu.hgschool.scoremanagement.entity.Exercise;
import cn.geekchu.hgschool.scoremanagement.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    public void getAllExercise() {
        List<Exercise> allExercise = exerciseService.getAllExercise(0, 0);
    }


    @PostMapping(value = "/exerciseList", produces = {"application/json;charset=UTF-8"})
    public void getExercise(@RequestParam(value = "p", required = true) int page, @RequestParam(value = "s", required = true) int size) {
        List<Exercise> allExercise = exerciseService.getAllExercise(page, size);
    }

    @GetMapping(value = "/exerciseCreate")
    public String toExerciseCreate(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "exercise/create";
    }


    @GetMapping(value = "/recordScore")
    public String recordScore(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "exercise/create";
    }

    @PostMapping("/exerciseCreate")
    public String exerciseSubmit(@ModelAttribute Exercise exercise) {
        return "result";
    }

    @RequestMapping(value = "/exerciseQuery")
    public String exerciseList(Model model) {
        List<Exercise> exerciseList = exerciseService.getAllExercise(0,10);
        model.addAttribute("exerciseList", exerciseList);
        return "exercise/list";
    }
}
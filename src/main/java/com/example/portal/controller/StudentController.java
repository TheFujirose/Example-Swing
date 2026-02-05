package com.example.portal.controller;

import com.example.portal.model.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    /**
     * List of students made.
     * TODO: switch with SQLite
     */
    private static @Nullable List<Student> students = new ArrayList<Student>();

    /**
     * Preprocessing that removes whitespace. Will replace that space with null so
     * there needs to be a handler for that exception
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    /**
     * Basic Index for binding example
     * @return the string of the thymeleaf template in resources
     */
    @GetMapping
    public String index(Model model){
        model.addAttribute(new Student());
        return "register";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Student student, Model model){
        if (students != null) { // This won't be here in later versions when I switch to SQL
            students.add(student);
        }
        model.addAttribute("students", students);
        return "confirm";
    }

    @ModelAttribute("courses")
    public List<String> getLevels(){
        return List.of("CPAN228","CPAN227","CPAN226","CPAN225","CPAN224","WORK111","WORK099");
    }

    @ModelAttribute("levels")
    public List<String> getCourses(){
        return List.of("university","college","trade");
    }
}

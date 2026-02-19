package com.example.portal.controller;

import com.example.portal.model.Student;
import com.example.portal.repository.StudentRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing a repository of Student objects.
 * Endpoints are as follows:
 * <ul>
 *     <li>students</li>
 *     <li>students/list</li>
 *     <li>students/add</li>
 *     <li>students/edit</li>
 *     <li>students/edit/{id}</li>
 *     <li>students/delete/{id}</li>
 * </ul>
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    /**
     * Repository for all students.
     */
    @Autowired
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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
     * The listing of all @link{model.Student Students} in the
     * @link{StudentController#studentRepository repository}
     * @param model the student model
     * @return the thymeleaf template to use
     */
    @GetMapping
    public String index(Model model) {
        model.addAttribute("students",studentRepository.findAll());
        return "students/home";
    }

    /**
     * The listing of all @link{model.Student Students} in the
     * @link{StudentController#studentRepository repository}
     * @param model the student model
     * @return the thymeleaf template to use
     */
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return "students/list";
    }

    /**
     * The page for the "/add" endpoint.
     * @param model the Student model
     * @return the string of the thymeleaf template in resources
     */
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("student",new Student());
        return "students/add";
    }

    /**
     * The "Post" for the endpoint "/add"
     * @param student the student model added
     * @return the thymeleaf template
     */
    @PostMapping("/add")
    public String save(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/students/list";
    }

    /**
     * The "edit/{id}" endpoint.
     * @param model the Student model
     * @param id the id of the Student model
     * @return the thymeleaf template to use
     */
   @GetMapping("edit/{id}")
   public String edit(Model model,@PathVariable Long id){
        model.addAttribute("student",studentRepository.findById(id));
        return "students/edit";
   }

    /**
     * The "post" for the "/edit" endpoint
     * @param student the student edited
     * @return the thymeleaf template to use
     */
   @PostMapping("/edit")
   public String edit(@ModelAttribute Student student){
       studentRepository.save(student);
       return "redirect:/students/list";
   }

    /**
     * Deletes the matching Student by the specified id from the repository
     * @param id the specified id
     * @return the thymeleaf template to use
     */
   @GetMapping("/delete/{id}")
   public String delete(@PathVariable Long id){
       studentRepository.deleteById(id);
       return "redirect:/students/list";
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

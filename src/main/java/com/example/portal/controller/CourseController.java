package com.example.portal.controller;

import com.example.portal.model.Course;
import com.example.portal.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing a repository of @link{model.Course} objects.
 * Endpoints are as follows:
 * <ul>
 *     <li>course</li>
 *     <li>course/add</li>
 *     <li>course/edit</li>
 *     <li>course/edit/{id}</li>
 *     <li>course/delete/{id}</li>
 * </ul>
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    /**
     * The controller for the Course objects
     */
    private CourseRepository courseRepository;

    /**
     * Initialize the courseRepository
     * @param courseRepository the course repository to set
     * @see CourseController#courseRepository
     */
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * The listing of all courses
     * @param model the course model
     * @return the thymeleaf template to use
     */
    @GetMapping
    public String list(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "course/list";
    }

    /**
     * The page for "/add" endpoint.
     * @param model the course model
     * @return the thymelead template to use
     */
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("course", new Course());
        return "course/add";
    }

    /**
     * The "Post" for endpoint "/add".
     * @param course the course model recieved
     * @return the thymeleaf template to use
     */
    @PostMapping("/add")
    public String add(@ModelAttribute Course course){
        courseRepository.save(course);
        return "redirect:/course";
    }

    /**
     * The "edit/{id}" endpoint.
     * @param model the course model
     * @param id the course id to edit
     * @return the thymeleaf template to use
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("course", courseRepository.findById(id));
        return "course/edit";
    }

    /**
     * The "post" for "/edit" endpoint
     * @param course the course edited
     * @return the thymeleaf template to use
     */
    @PostMapping("/edit")
    public String edit(@ModelAttribute Course course){
        courseRepository.save(course);
        return "redirect:/course";
    }

    /**
     * Deletes the matching course by specified id from @link{Course#courseRepository}
     * @param id the specified id
     * @return the thymeleaf template to use
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        courseRepository.deleteById(id);
        return "redirect:/course";
    }
}
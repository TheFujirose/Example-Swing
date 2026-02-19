package com.example.portal.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.portal.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {}
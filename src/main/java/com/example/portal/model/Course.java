package com.example.portal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Carson Fujita
 * @since 2.0.0
 *
 * Defines a course at a university, college, or other academic insitution.
 * Contains values for:
 * <ul>
 *     <li>id</li>
 *     <li>title</li>
 *     <li>instructor</li>
 * </ul>
 */
@Table("course")
public class Course {

    /**
     * The enumerate identification number for the Course.
     * @since 2.0.0
     */
    @Id
    private Long id;

    /**
     * The title / name of the Course.
     * @since 2.0.0
     */
    private String title;

    /**
     * The name of the instructor of the course.
     * @since 2.0.0
     */
    private String instructor;

    /**
     * Gets the id of this Course
     *
     * @see Course#id
     * @see Course#setId
     */
    public Long
    getId() {
        return id;
    }

    /**
     * Sets the id of this Course
     *
     * @param id the id to set
     * @see Course#id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title of this Course
     *
     * @see Course#title
     * @see Course#setTitle
     */
    public String
    getTitle() {
        return title;
    }

    /**
     * Sets the title of this Course
     *
     * @param title the title to set
     * @see Course#title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the instructor of this Course
     *
     * @see Course#instructor
     * @see Course#setInstructor
     */
    public String
    getInstructor() {
        return instructor;
    }

    /**
     * Sets the instructor of this Course
     *
     * @param instructor the instructor to set
     * @see Course#instructor
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}

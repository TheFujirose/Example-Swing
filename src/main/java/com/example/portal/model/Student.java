package com.example.portal.model;

/**
 * @author Carson Fujita
 * @since 1.0.0
 *
 * Describes a model of a student in a school with properties defining their
 * - name
 * - email
 * - course
 * - level of study
 * Additionally contains an id
 */
public class Student {

    /**
     * The enumerate identification number for the Student.
     * @since 1.0.0
     */
    private int id;

    /**
     * The full-name of the Student.
     * @since 1.0.0
     */
    private String name;

    /**
     * The primary email for the Student.
     * @since 1.0.0
     */
    private String email;

    /**
     * The selected course for the Student.
     * @since 1.0.0
     */
    private String course;

    /**
     * The level of study for the Student.
     * <br/>
     * Best described by:
     * <ul>
     *     <li>University</li>
     *     <li>College</li>
     *     <li>Trades</li>
     * </ul>
     * @since 1.0.0
     */
    private String level;

    /**
     * Gets the id of this Student
     *
     * @see Student#id
     * @see Student#setId
     */
    public int
    getId() {
        return id;
    }

    /**
     * Sets the id of this Student
     *
     * @param id the id to set
     * @see Student#id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of this Student
     *
     * @see Student#name
     * @see Student#setName
     */
    public String
    getName() {
        return name;
    }

    /**
     * Sets the name of this Student
     *
     * @param name the name to set
     * @see Student#name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of this Student
     *
     * @see Student#email
     * @see Student#setEmail
     */
    public String
    getEmail() {
        return email;
    }

    /**
     * Sets the email of this Student
     *
     * @param email the email to set
     * @see Student#email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the course of this Student
     *
     * @see Student#course
     * @see Student#setCourse
     */
    public String
    getCourse() {
        return course;
    }

    /**
     * Sets the course of this Student
     *
     * @param course the course to set
     * @see Student#course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Gets the level of this Student
     *
     * @see Student#level
     * @see Student#setLevel
     */
    public String
    getLevel() {
        return level;
    }

    /**
     * Sets the level of this Student
     *
     * @param level the level to set
     * @see Student#level
     */
    public void setLevel(String level) {
        this.level = level;
    }
}

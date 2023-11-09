package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person implements Evaluation
{
    private double average;
    private final List<Course> courses = new ArrayList<>();
    private final Map<String, Course> approvedCourses = new HashMap<>();
    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }
    private double grade;
    private Map<Course, Double> courseGrades = new HashMap<>();

    public List<Course> getCourses() {
        return this.courses; // returns the list of courses
    }

    public void setGradeForCourse(Course course, double grade) {
        this.courseGrades.put(course, grade);
    }

    public Double getGradeForCourse(Course course) {
        return this.courseGrades.get(course);
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method
        this.courses.add(course); // adds course to list of courses
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode ) // methods checks if student is approved for the course.
    {
        //TODO implement this method
        return approvedCourses.containsKey(courseCode); // returns true if courseCode is in the approvedCourses map.
    } // otherwise returns false.

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses( Course course ) {
        //TODO implement this method
        return null;
    }

    public boolean isAttendingCourse( String courseCode ) { // methods checks if student is enrolled in a course
        //TODO implement this method
        for (Course course : courses) { // using forEach loop to check if courseCode is in student's course list
            if (course.getCode().equals(courseCode)) {
                return true; //
            }
        }
        return false;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses() // returns a list of courses that student has passed.
    {
        //TODO implement this method
        return new ArrayList<>(approvedCourses.values());
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}

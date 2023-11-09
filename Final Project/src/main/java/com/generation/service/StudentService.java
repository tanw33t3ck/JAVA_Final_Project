package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId ) //checks studentID to confirm student status
    {
        //TODO implement this method
        return students.containsKey(studentId); // returns true if student list contains studentId
    } // returns false otherwise.

    public void showSummary() // methods to show student ID and courses the student is taking
    {
        //TODO implement
        for (Student student : students.values()){ // iterates through the student hashmap
            System.out.println("Student ID: " + student.getId()); // print out student ID
            System.out.println("Courses: ");
            for (Course course : student.getCourses())
            {
                System.out.println("\t Course ID: " + course.getCode());
            }
            System.out.println("\n");
        }



    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }


}

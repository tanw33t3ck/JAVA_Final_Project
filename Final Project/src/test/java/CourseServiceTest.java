import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import com.generation.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseService courseService;
    private Student student;
    private Course course;
    private Module module;

    @BeforeEach // instantiates test objects, student, course and module for the tests
    public void setUp() {
        courseService = new CourseService();
        student = new Student("1", "Michael Wong", "michael@wong.com", new Date());
        module = new Module("CS101", "Intro to Java", "Intro to CS");
        course = new Course("CS101", "Computer Science", 3, module);
    }

    @Test // Test 1: test registerCourse method in CourseService class
    void registerCourse() {
        courseService.registerCourse(course); // pass course object as a parameter and
        assertEquals(course, courseService.getCourse(course.getCode())); // checks if course.getCode() returns the correct course code.
    }

    @Test // Test 2: test enrollStudent method in CourseService class
    void enrollStudent() {
        courseService.registerCourse(course); // pass course object as a parameter and
        courseService.enrollStudent(course.getCode(), student); // enrolls students into the course using the enrollStudent method in CourseService class
        assertTrue(courseService.getEnrolledStudents(course.getCode()).contains(student)); // expected output: true. Outputs true if said course list of enrolled students contains said student id.
    }

}
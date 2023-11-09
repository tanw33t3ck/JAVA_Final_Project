import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import com.generation.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;
    private Student student;
    private Course course;
    private Module module;

    @BeforeEach // instantiate test student, test module and test course objects
    public void setUp() {
        studentService = new StudentService();
        student = new Student("1", "Michael Wong", "michael@wong.com", new Date());
        module = new Module("CS101", "Intro to JAVA", "Intro to CS");
        course = new Course("CS101", "Computer Science", 3, module);
    }

    @Test // Test 1: test subscribeStudent method to check if test student object is successfully added to student map with student ID as key
    public void subscribeStudent() {
        studentService.subscribeStudent(student);
        assertTrue(studentService.isSubscribed(student.getId())); // output expected to be true
    }

    @Test // Test 2: test enrollToCourse method
    public void enrollToCourse() {
        studentService.subscribeStudent(student); // first subscribed a student
        studentService.enrollToCourse(student.getId(), course); // and using enrollToCourse method to add course object to subscribed student
        assertTrue(student.getCourses().contains(course)); // output expected to be true
    }

}
package com.example.CourseRegistrationSystem.Controller;
import com.example.CourseRegistrationSystem.Model.Course;
import com.example.CourseRegistrationSystem.Model.CourseRegistry;
import com.example.CourseRegistrationSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping("/courses")
    public List<Course> getAll() {

        return service.getAll();
    }

    @GetMapping("/courses/enrolled")
    public List<CourseRegistry> enrolledStudents() {

        return service.enrolledStudents();
    }

    @PostMapping("/courses/register")
    public String enrolledCourses(@RequestParam String name,
            @RequestParam String emailId,
            @RequestParam String courseName) {
        service.enrolledCourse(name, emailId, courseName);
        return "Congratulations!" + name + " Enrollement Succesfull for " + courseName;
    }

}

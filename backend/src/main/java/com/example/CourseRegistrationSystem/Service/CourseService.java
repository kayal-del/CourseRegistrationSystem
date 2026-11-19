package com.example.CourseRegistrationSystem.Service;

import com.example.CourseRegistrationSystem.Model.Course;
import com.example.CourseRegistrationSystem.Model.CourseRegistry;
import com.example.CourseRegistrationSystem.Repository.CourseRegistryRepo;
import com.example.CourseRegistrationSystem.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo repo1;
    @Autowired
    private CourseRegistryRepo repo2;

    public List<Course> getAll()
    {
        return repo1.findAll();
    }

    public List<CourseRegistry> enrolledStudents() {
        return repo2.findAll();
    }

    public void enrolledCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry= new CourseRegistry(name,emailId,courseName);
        repo2.save(courseRegistry);
    }
}

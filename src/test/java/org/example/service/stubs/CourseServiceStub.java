package org.example.service;

import java.util.Arrays;
import java.util.List;

public class CourseServiceStub implements CourseService{
    @Override
    public List<String> retrieveCourses(String student) {
        return Arrays.asList("");
    }
}

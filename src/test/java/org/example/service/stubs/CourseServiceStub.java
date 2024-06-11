package org.example.service.stubs;

import org.example.service.CourseService;

import java.util.Arrays;
import java.util.List;

public class CourseServiceStub implements CourseService {
    @Override
    public List<String> retrieveCourses(String student) {
        return Arrays.asList(
                "REST API's RESTFul do 0 á Azure com ASP.NET",
                "Agile Desmitificado",
                "Spotify Engineering",
                "REST API's RESTFul do 0 á AWS com Spring Boot 3 java",
                "REST API's RESTFul do 0 á AWS com Spring Boot 3 Kotlin",
                "Microsserviços do 0 a AWS com Spring Cloud",
                "Arquitetura de microsserviços",
                "Kotlin para DEV's");
    }

    @Override
    public List<String> doSomething(String student) {
        return List.of();
    }

    @Override
    public void deleteCourse(String course) {

    }
}

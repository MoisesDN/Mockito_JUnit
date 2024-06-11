package org.example.business;

import org.example.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup() {
        //Given / Arrange
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 á Azure com ASP.NET",
                "Agile Desmitificado",
                "Spotify Engineering",
                "REST API's RESTFul do 0 á AWS com Spring Boot 3 java",
                "REST API's RESTFul do 0 á AWS com Spring Boot 3 Kotlin",
                "Microsserviços do 0 a AWS com Spring Cloud",
                "Arquitetura de microsserviços",
                "Kotlin para DEV's"
        );
    }

    @Test
    void testCoursesRelatedToString_When_UsingMock() {

        //When / Act
        when(mockService.retrieveCourses("Leandro"))
                .thenReturn(courses);

        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        //Then / Assert
        assertEquals(3, filteredCourses.size());
    }

}

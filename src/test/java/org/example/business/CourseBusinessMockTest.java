package org.example.business;

import org.example.service.CourseService;
import org.example.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseBusinessStubsTest {

    @Test
    void testCoursesRelatedToString_When_UsingAStub() {

        //Given / Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        //When / Act
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        //Then / Assert
        assertEquals(3, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToString_When_UsingAFooBarStudent() {

        //Given / Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        //When / Act
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");

        //Then / Assert
        assertEquals(0, filteredCourses.size());
    }
}

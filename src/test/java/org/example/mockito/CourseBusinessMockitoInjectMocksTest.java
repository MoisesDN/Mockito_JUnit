package org.example.mockito;

import org.example.business.CourseBusiness;
import org.example.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {

    @Mock
    CourseService mockService;

    @InjectMocks
    CourseBusiness business;

    @Captor
    ArgumentCaptor<String> argumentCaptor;
    List<String> courses;

    @BeforeEach
    void setup() {
        //Given / Arrange
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
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        //Then / Assert
        assertThat(filteredCourses.size(), is(3));
    }

    @DisplayName("Delete Courses not Related to spring using Mockito sould call Method")
    @Test
    void testCoursesRelatedToString_When_UsingMockitoVerify_should_CallMethod_deleteCourse() {

        //Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);
        //When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");
        //Then / Assert


        verify(mockService, atLeastOnce()).deleteCourse("Agile Desmitificado");
        verify(mockService).deleteCourse("Arquitetura de microsserviços");
        verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 á AWS com Spring Boot 3 java");
    }

    @DisplayName("Delete Courses not Related to spring using Mockito sould call Method deleteCourseV2")
    @Test
    void testCoursesRelatedToString_When_UsingMockitoVerify_should_CallMethod_deleteCourseV2() {

        //Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);
        //When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");
        //Then / Assert

        String agileDesmitificado = "Agile Desmitificado";
        String course = "REST API's RESTFul do 0 á AWS com Spring Boot 3 java";
        String microsserviços = "Arquitetura de microsserviços";

        then(mockService)
                .should()
                .deleteCourse(agileDesmitificado);

        then(mockService)
                .should()
                .deleteCourse(microsserviços);

        then(mockService)
                .should(never())
                .deleteCourse(course);
    }

    @DisplayName("Delete Courses not Related to spring Capturing Arguments should call Method deleteCourseV2")
    @Test
    void testCoursesRelatedToString_When_CaptureArguments_should_CallMethod_deleteCourseV2() {

        //Given / Arrange

        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

       // ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String agileDesmitificado = "Agile Desmitificado";
        //When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");
        //Then / Assert

        then(mockService)
                .should(times(5))
                .deleteCourse(argumentCaptor.capture());

        assertThat(argumentCaptor.getAllValues().size(), is(5));

    }

}

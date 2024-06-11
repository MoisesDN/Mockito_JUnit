package org.example.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void testMockingList_given_SizeIsCalled_ShouldReturn10() {

        //Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        //given / Act & Then / Assert
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(10));

    }

    @Test
    void testMockingList_given_SizeIsCalled_ShouldReturnMultipleValues() {

        //Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        //given / Act & Then / Assert
        assertThat( list.size(), is(10));
        assertThat( list.size(), is(20));
        assertThat( list.size(), is(20));
    }

    @Test
    void testMockingList_given_GetIsCalled_ShouldReturnMoises() {

        //Given / Arrange
        var list = mock(List.class);
        given(list.get(0)).willReturn("Moises");

        //given / Act & Then / Assert
        assertThat(list.get(0),is("Moises"));
        assertNull(list.get(1));

    }

    @Test
    void testMockingList_given_GetIsCalledWithArgumentMatcher_ShouldReturnMoises() {

        //Given / Arrange
        var list = mock(List.class);
        given(list.get(anyInt())).willReturn("Moises");

        //given / Act & Then / Assert
        assertThat(list.get(anyInt()), is("Moises"));

    }

    @Test
    void testMockingList_given_ThrowAnException() {

        //Given / Arrange
        var list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!!"));

        //given / Act & Then / Assert
        assertThrows(RuntimeException.class,
                () -> {list.get(anyInt());},
                () -> "Should have throw an RuntimeException");

    }
}

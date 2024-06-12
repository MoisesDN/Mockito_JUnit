package org.example.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @DisplayName("Spy Test")
    @Test
    void testV1() {

        //Given / Arrange
        List<String> mockArrayList = spy(ArrayList.class);

        //When & Then / Assert
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);
        mockArrayList.add("Foo-Bar");

        assertEquals(5, mockArrayList.size());
    }

    @DisplayName("Spy TestV2")
    @Test
    void testV2() {

        //Given / Arrange
        List<String> spyArrayList = spy(ArrayList.class);

        //When & Then / Assert
        assertEquals(0, spyArrayList.size());

        spyArrayList.add("Foo-Bar");
        assertEquals(1, spyArrayList.size());

        spyArrayList.remove("Foo-Bar");
        assertEquals(0, spyArrayList.size());
    }

    @DisplayName("Spy TestV3")
    @Test
    void testV3() {

        //Given / Arrange
        List<String> spyArrayList = spy(ArrayList.class);

        //When & Then / Assert
        assertEquals(0, spyArrayList.size());
        when(spyArrayList.size()).thenReturn(5);
        assertEquals(5, spyArrayList.size());

    }

    @DisplayName("Spy TestV4")
    @Test
    void testV4() {

        //Given / Arrange
        List<String> spyArrayList = spy(ArrayList.class);
        //When & Then / Assert
        spyArrayList.add("Foo-Bar");
        verify(spyArrayList).add("Foo-Bar");
        //verify(spyArrayList, never()).remove("Foo-Bar");
        verify(spyArrayList, never()).remove(anyString());
        verify(spyArrayList, never()).clear();

    }
}

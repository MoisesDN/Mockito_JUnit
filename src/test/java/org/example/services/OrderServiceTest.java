package org.example.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2024, 6, 12, 16,18);

    @DisplayName("Should Include Random OrderId When No OrderId Exists!")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {

        //Given / Arrange
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {

            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            //When / Act
            Order result = service.createOrder("MacBook Pro", 2L, null);

            //Then / Assert
            assertEquals(defaultUuid.toString(), result.getId());
        }

    }

    @DisplayName("Should Include CurrentTime When Create a New Order!")
    @Test
    void testShouldIncludeCurrentTime_When_CreateNewOrder() {

        //Given / Arrange
        try(MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {

            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            //When / Act
            Order result = service.createOrder("MacBook Pro", 2L, null);

            //Then / Assert
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }

    }
}

package ru.java.meetup.starter.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.java.meetup.starter.service.MessageService;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {
    private static final String MESSAGE = "Hello World!";

    private MessageService messageService;

    @BeforeEach
    void setUp() {
        messageService = new MessageServiceImpl(MESSAGE);
    }

    @Test
    void getMessage() {
        assertEquals(MESSAGE, messageService.getMessage());
    }
}

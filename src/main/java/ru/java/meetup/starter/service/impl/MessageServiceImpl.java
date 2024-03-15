package ru.java.meetup.starter.service.impl;

import ru.java.meetup.starter.service.MessageService;

public class MessageServiceImpl implements MessageService {
    private final String message;

    public MessageServiceImpl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

package ru.java.meetup.starter.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ru.java.meetup.starter.controller.MessageController;
import ru.java.meetup.starter.service.MessageService;
import ru.java.meetup.starter.service.impl.MessageServiceImpl;

@AutoConfiguration
@Import(MessageController.class)
public class MessageStarterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(MessageService.class)
    public MessageService messageService(@Value("${app.message}") String message) {
        return new MessageServiceImpl(message);
    }

}

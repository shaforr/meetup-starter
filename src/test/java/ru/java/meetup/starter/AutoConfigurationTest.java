package ru.java.meetup.starter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import ru.java.meetup.starter.autoconfiguration.MessageStarterAutoConfiguration;
import ru.java.meetup.starter.service.MessageService;

import static org.assertj.core.api.Assertions.assertThat;

class AutoConfigurationTest {

    private static final String MESSAGE = "Hello World!";
    private final WebApplicationContextRunner contextRunner = new WebApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(MessageStarterAutoConfiguration.class));


    @Test
    public void testGetMessage() {
        this.contextRunner
                .withPropertyValues("app.message=%s".formatted(MESSAGE))
                .run(context -> {
                    assertThat(context).hasSingleBean(MessageService.class);
                    assertThat(context.getBean(MessageService.class).getMessage()).isEqualTo(MESSAGE);
                });
    }
}

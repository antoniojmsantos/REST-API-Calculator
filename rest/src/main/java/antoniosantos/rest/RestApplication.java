package antoniosantos.rest;

import antoniosantos.calculator.config.CalculatorConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CalculatorConfig.class)
public class RestApplication {



    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }


}

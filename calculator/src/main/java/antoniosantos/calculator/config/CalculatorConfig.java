package antoniosantos.calculator.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "antoniosantos")
public class CalculatorConfig {
    public static final String EXCHANGE_NAME = "calculator_tx";
    public static final String DEFAULT_PARSING_QUEUE = "default_parser_q";
    public static final String ROUTING_KEY = "calculator";

    @Bean
    public TopicExchange operationsExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue defaultParsingQueue(){
        return new Queue(DEFAULT_PARSING_QUEUE);
    }

    @Bean
    public Binding queueToExchangeBinding(){
        return BindingBuilder.bind(defaultParsingQueue()).to(operationsExchange()).with(ROUTING_KEY);
    }
}

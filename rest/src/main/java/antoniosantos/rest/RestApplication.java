package antoniosantos.rest;

import antoniosantos.calculator.config.CalculatorConfig;
import antoniosantos.rest.filters.MDCFilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CalculatorConfig.class, MDCFilterConfig.class})
public class RestApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }


}

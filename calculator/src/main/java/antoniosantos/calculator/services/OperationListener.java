package antoniosantos.calculator.services;

import antoniosantos.calculator.config.CalculatorConfig;
import antoniosantos.calculator.controllers.CalculatorController;
import antoniosantos.calculator.models.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OperationListener {
    private static final Logger log =  LoggerFactory.getLogger(OperationListener.class);

    @RabbitListener(queues = CalculatorConfig.DEFAULT_PARSING_QUEUE)
    public BigDecimal consumeNewOperation(final Operation operation){
        log.info("Consumed new operation: " + operation);
        return CalculatorController.calculate(operation);
    }

}

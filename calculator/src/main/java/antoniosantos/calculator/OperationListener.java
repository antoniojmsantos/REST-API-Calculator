package antoniosantos.calculator;

import antoniosantos.calculator.config.CalculatorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OperationListener {
    private static final Logger log =  LoggerFactory.getLogger(OperationListener.class);

    @RabbitListener(queues = CalculatorConfig.DEFAULT_PARSING_QUEUE)
    public int consumeOperation(final Operation operation){
        log.info(operation.getOperation().toString());
        switch (operation.getOperation()){
            case SUM:
                return operation.getA() + operation.getB();
            case SUB:
                return  operation.getA() - operation.getB();
            case DIV:
                return operation.getA() / operation.getB();
            case MUL:
                return operation.getA() * operation.getB();
        }

        return 0;
    }

}

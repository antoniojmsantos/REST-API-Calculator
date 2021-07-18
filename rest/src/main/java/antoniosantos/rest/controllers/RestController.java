package antoniosantos.rest.controllers;

import antoniosantos.calculator.config.CalculatorConfig;
import antoniosantos.calculator.models.OP;
import antoniosantos.calculator.models.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Collections;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

    private static final Logger log =  LogManager.getLogger(RestController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ResponseEntity<Object> produceNewOperation(Operation op){
        log.info("Produced new operation: " + op);

        BigDecimal response = (BigDecimal) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);

        return ResponseEntity.status(HttpStatus.OK).body(
                Collections.singletonMap("result", response));
    }


    @GetMapping("/sum")
    public ResponseEntity<Object> sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        Operation op = new Operation(OP.SUM, a, b);
        return produceNewOperation(op);
    }

    @GetMapping("/sub")
    public ResponseEntity<Object> sub(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        Operation op = new Operation(OP.SUB, a, b);
        return produceNewOperation(op);
    }

    @GetMapping("/div")
    public ResponseEntity<Object> div(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        if(b.compareTo(BigDecimal.ZERO) == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Collections.singletonMap("result", "can't divide by 0"));
        }
        Operation op = new Operation(OP.DIV, a, b);
        return produceNewOperation(op);
    }

    @GetMapping("/mul")
    public ResponseEntity<Object> mul(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        Operation op = new Operation(OP.MUL, a, b);
        return produceNewOperation(op);
    }
}

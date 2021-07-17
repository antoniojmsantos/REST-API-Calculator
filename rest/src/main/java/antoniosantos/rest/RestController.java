package antoniosantos.rest;

import antoniosantos.calculator.Operation;
import antoniosantos.calculator.config.CalculatorConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sum")
    public float sum(@RequestParam Float a, @RequestParam Float b){
        Operation op = new Operation(Operation.OP.SUM, a, b);
        Float response = (Float) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
    }

    @GetMapping("/sub")
    public float sub(@RequestParam Float a, @RequestParam Float b){
        Operation op = new Operation(Operation.OP.SUB, a, b);
        Float response = (Float) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
    }

    @GetMapping("/div")
    public float div(@RequestParam Float a, @RequestParam Float b){
        Operation op = new Operation(Operation.OP.DIV, a, b);
        Float response = (Float) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
    }

    @GetMapping("/mul")
    public float mul(@RequestParam Float a, @RequestParam Float b){
        Operation op = new Operation(Operation.OP.MUL, a, b);
        Float response = (Float) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
    }
}

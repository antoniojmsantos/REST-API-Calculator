package antoniosantos.rest;

import antoniosantos.calculator.Calculator;
import antoniosantos.calculator.Operation;
//import antoniosantos.calculator.OperationSender;
import antoniosantos.calculator.config.CalculatorConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

//    @Autowired
//    private Calculator calculator;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sum")
    public int sum(@RequestParam Integer a, @RequestParam Integer b){
        Operation op = new Operation(Operation.OP.SUM, a, b);
        Integer response = (Integer) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
//        return calculator.calculate(Calculator.OP.SUM, a, b);
    }

    @GetMapping("/sub")
    public int sub(@RequestParam Integer a, @RequestParam Integer b){
//        return calculator.calculate(Calculator.OP.SUB, a, b);
        Operation op = new Operation(Operation.OP.SUB, a, b);
        Integer response = (Integer) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
    }

    @GetMapping("/div")
    public int div(@RequestParam Integer a, @RequestParam Integer b){
//        return calculator.calculate(Calculator.OP.DIV, a, b);
        Operation op = new Operation(Operation.OP.DIV, a, b);
        Integer response = (Integer) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
    }

    @GetMapping("/mul")
    public int mul(@RequestParam Integer a, @RequestParam Integer b){
//        return calculator.calculate(Calculator.OP.MUL, a, b);
        Operation op = new Operation(Operation.OP.MUL, a, b);
        Integer response = (Integer) rabbitTemplate.convertSendAndReceive(CalculatorConfig.EXCHANGE_NAME, CalculatorConfig.ROUTING_KEY, op);
        return response;
    }
}

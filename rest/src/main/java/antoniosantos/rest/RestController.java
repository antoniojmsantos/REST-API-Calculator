package antoniosantos.rest;

import antoniosantos.calculator.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

    @Autowired
    private Calculator calculator;


    @GetMapping("/sum")
    public Integer sum(@RequestParam Integer a, @RequestParam Integer b){
        return calculator.calculate(Calculator.OP.SUM, a, b);
    }

    @GetMapping("/sub")
    public Integer sub(@RequestParam Integer a, @RequestParam Integer b){
        return calculator.calculate(Calculator.OP.SUB, a, b);
    }

    @GetMapping("/div")
    public Integer div(@RequestParam Integer a, @RequestParam Integer b){
        return calculator.calculate(Calculator.OP.DIV, a, b);
    }

    @GetMapping("/mul")
    public Integer mul(@RequestParam Integer a, @RequestParam Integer b){
        return calculator.calculate(Calculator.OP.MUL, a, b);
    }
}

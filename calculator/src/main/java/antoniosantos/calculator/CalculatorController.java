package antoniosantos.calculator;

import org.springframework.stereotype.Component;

@Component
public class CalculatorController implements Calculator {

    @Override
    public int calculate(OP operation, Integer a, Integer b){
        switch (operation){
            case SUM:
                return a+b;
            case SUB:
                return  a-b;
            case DIV:
                return a/b;
            case MUL:
                return a*b;
        }

        return 0;
    }

}

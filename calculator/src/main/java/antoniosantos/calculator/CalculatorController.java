package antoniosantos.calculator;

import org.springframework.stereotype.Component;

@Component
public class CalculatorController {

    public static float calculate(final Operation operation){
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

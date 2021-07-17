package antoniosantos.calculator.controllers;

import antoniosantos.calculator.models.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CalculatorController {

    public static BigDecimal calculate(final Operation operation){
        switch (operation.getOperation()){
            case SUM:
                return operation.getA().add(operation.getB());
            case SUB:
                return operation.getA().subtract(operation.getB());
            case DIV:
                return operation.getA().divide(operation.getB(), 2, RoundingMode.CEILING); // 2 decimal
            case MUL:
                return operation.getA().multiply(operation.getB());
        }

        return null;
    }

}

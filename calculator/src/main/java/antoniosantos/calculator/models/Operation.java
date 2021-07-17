package antoniosantos.calculator.models;


import java.io.Serializable;
import java.math.BigDecimal;

public class Operation implements Serializable {

    private final OP operation;
    private final BigDecimal a;
    private final BigDecimal b;

    public Operation(OP operation, BigDecimal a, BigDecimal b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public OP getOperation() {
        return operation;
    }

    public BigDecimal getA() {
        return a;
    }

    public BigDecimal getB() {
        return b;
    }

    @Override
    public String toString(){

        return "Operation: " + operation + " | A = " + a + " | B = " + b + " |";
    }
}

package antoniosantos.calculator;


import java.io.Serializable;

public class Operation implements Serializable, Calculator {

    private final OP operation;
    private final int a;
    private final int b;

    public Operation(OP operation, int a, int b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public OP getOperation() {
        return operation;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

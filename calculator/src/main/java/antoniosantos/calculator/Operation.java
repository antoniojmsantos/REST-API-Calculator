package antoniosantos.calculator;


import java.io.Serializable;

public class Operation implements Serializable {

    public enum OP {
        SUM,
        SUB,
        DIV,
        MUL
    }

    private final OP operation;
    private final float a;
    private final float b;

    public Operation(OP operation, float a, float b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public OP getOperation() {
        return operation;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }
}

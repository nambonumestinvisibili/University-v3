package calculations;

public abstract class UnaryOperator extends Expression {
    Expression operand1;
    protected String functionName;

    public UnaryOperator(Expression expr){
        operand1 = expr;
    }

    public UnaryOperator() { }

    @Override
    public String toString() {
        return functionName +
                "(" + operand1 +
                ')';
    }
}

package calculations;

public abstract class BinaryOperator extends UnaryOperator {
    protected Expression operand2;


    public BinaryOperator(Expression expr, Expression expr2) {
        super(expr);
        this.operand2 = expr2;
    }

    public BinaryOperator(Expression expr) {
        super(expr);
    }

    public BinaryOperator() {
        super( );
    }

    public String toString(){
        return functionName + "(" + operand1.toString()
                + ", " + operand2.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryOperator that = (BinaryOperator) o;

        return operand2.equals(that.operand2) && operand1.equals(that.operand1);
    }
}

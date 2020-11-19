package instructions;

import calculations.Expression;

public class WriteStream extends Instruction {
    Expression expression;

    public WriteStream(Expression expression){
        this.expression = expression;
    }

    @Override
    public void execute() throws Exception {
        System.out.println(expression.calculate());
    }
}

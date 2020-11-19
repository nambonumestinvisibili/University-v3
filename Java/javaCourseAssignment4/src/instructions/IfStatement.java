package instructions;

import calculations.Expression;

public class IfStatement extends Instruction {

    Expression condition;
    Instruction instrTrue;

    public IfStatement(Expression condition, Instruction instrTrue){
        this.condition = condition;
        this.instrTrue = instrTrue;
    }


    @Override
    public void execute() throws Exception {
        if (condition.calculate() == 0){
            instrTrue.execute();
        }
    }
}

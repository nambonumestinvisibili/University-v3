package instructions;

import calculations.Expression;

public class IfElseStatement extends Instruction {

    Expression condition;
    Instruction instrTrue, instrFalse;

    public IfElseStatement(Expression condition, Instruction instrTrue, Instruction instrFalse){
        this.condition = condition;
        this.instrFalse = instrFalse;
        this.instrTrue = instrTrue;
    }


    @Override
    public void execute() throws Exception {
        if (condition.calculate() == 0){
            instrFalse.execute();
        }
        else {
            instrTrue.execute();
        }
    }
}

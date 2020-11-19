package instructions;

import calculations.Expression;

public class WhileStatement extends Instruction {

    Expression condition;
    Instruction instruction;

    public WhileStatement(Expression condition, Instruction instruction){
        this.condition = condition;
        this.instruction = instruction;
    }

    @Override
    public void execute() throws Exception {
        while (condition.calculate() != 0){
            Instruction ins = instruction;
            ins.execute();
        }
    }
}

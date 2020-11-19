package instructions;

import calculations.Expression;

public class DoWhileStatement {
    Expression condition;
    Instruction instruction;

    DoWhileStatement(Expression condition, Instruction instruction){
        this.condition = condition;
        this.instruction = instruction;
    }

    public void execute() throws Exception {
        instruction.execute();
        Instruction w = new WhileStatement(condition, instruction);
        w.execute();
    }
}

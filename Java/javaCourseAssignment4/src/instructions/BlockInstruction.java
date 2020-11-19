package instructions;

import calculations.Variable;

import java.util.ArrayList;
import java.util.Arrays;

public class BlockInstruction extends Instruction {

    ArrayList<Instruction> instructions;
    ArrayList<String> createdVariablesInThisBlock;

    public BlockInstruction(Instruction... instructions) throws Exception {
        for (Instruction instr : instructions){
            if (instr instanceof VariableDeclaration){
                instr.execute();
            }
        }
        this.instructions = new ArrayList<Instruction>();
        this.instructions.addAll(Arrays.asList(instructions));
        this.createdVariablesInThisBlock = new ArrayList<>();
    }

    @Override
    public void execute() throws Exception {
        for(Instruction inst : instructions){
            if (inst instanceof VariableDeclaration){
                createdVariablesInThisBlock.add(
                        ((VariableDeclaration) inst).getDeclaredVariableId());
            }
            inst.execute();
        }

        Variable.clearBlockVariables(createdVariablesInThisBlock);
    }
}

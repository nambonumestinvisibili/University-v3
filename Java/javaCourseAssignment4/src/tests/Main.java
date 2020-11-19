package tests;
import calculations.*;
import calculations.Number;
import instructions.*;
import jdk.nashorn.internal.ir.Block;

public class Main {

    public static void main(String[] args) throws Exception {
//        testInstructions();
//        testCalculations();
        Instruction declars = new BlockInstruction(
                new VariableDeclaration("n"),
                new Assignment("n", new Number(10))
        );
        declars.execute();

        Instruction instr = new WhileStatement(
                new GreaterThan(new Variable("n"), new Number(5)),
                new Assignment("n", new Substraction(new Variable("n"), new Number(1)))
        );
        instr.execute();
    }

    public static void testCalculations() throws Exception {
        Variable x = new Variable("x", 2);
        Variable y = new Variable("y", 1);

        Expression e1 = new Addition(new Number(3), new Number(5));
        System.out.println(e1 + " = " + e1.calculate());

        Expression e2 = new Multiplication(
                new ReverseSign(
                        new Substraction(
                                new Number(2),
                                x
                        )
                ),
                new Number(7)
        );
        System.out.println(e2 + " = " + e2.calculate());

        Expression e3 = new Division(
                new Substraction(
                        new Multiplication(
                                new Number(3),
                                new Number(11)
                        ),
                        new Number(1)
                ),
                new Addition(
                        new Number(7),
                        new Number(5)
                )
        );
        System.out.println(e3 + " = " + e3.calculate());

        Expression e4 = new Minimum(
                new Multiplication(
                        new Addition(
                                x,
                                new Number(13)
                        ),
                        x
                ),
                new ModuloDivision(
                        new Substraction(
                                new Number(1),
                                x
                        ),
                        new Number(2)
                )
        );
        System.out.println(e4 + " = " + e4.calculate());

        Expression e5 = new LessThan(
                new Addition(
                        new Exponentation(
                                new Number(2),
                                new Number(5)
                        ),
                        new Multiplication(
                                x,
                                new DiscreteLogarithm(
                                        new Number(2),
                                        new Variable("y")
                                )
                        )
                ),
                new Number(20)
        );
        System.out.println(e5 + " = " + e5.calculate());
    }

    public static void testInstructions() throws Exception {

        Instruction declars = new BlockInstruction(
                new VariableDeclaration("n"),
                new ReadStream("n")
        );
        declars.execute();

        Instruction declars2 = new BlockInstruction(
                new VariableDeclaration("p"),
                new Assignment("p", new Number(2)),
                new VariableDeclaration("n")
        );
        declars2.execute();

        Instruction instruction = new BlockInstruction(
                new IfElseStatement(
                        new LessThan(new Variable("n"), new Number(2)),
                        new WriteStream(new Number(0)),
                        new BlockInstruction(
                                new IfStatement(
                                        new Equality(
                                                new ModuloDivision(
                                                        new Variable("n"),
                                                        new Variable("p")),
                                                new Number(0)
                                        ),
                                        new BlockInstruction(
                                                new Assignment("wyn", new Variable("p")),
                                                new Assignment("p", new Variable("n"))
                                        )
                                ),
                                new Assignment("p",
                                        new Addition(new Variable("p"), new Number(1))),
                                new IfElseStatement(
                                        new GreaterThan(new Variable("wyn"), new Number(0)),
                                        new WriteStream(new Number(0)),
                                        new WriteStream(new Number(1))
                                )
                        )
                )
        );
        instruction.execute();
        System.out.println(Variable.getEnvironment());
    }
}



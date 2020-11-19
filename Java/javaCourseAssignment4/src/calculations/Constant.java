package calculations;

public class Constant extends Expression {
    private int value;

    public Constant(String name) throws Exception {
        if (name.equals("pi")) this.value = 3;
        else if(name.equals("fi")) this.value = 1;
        else if(name.equals("e")) this.value = 2;
        else {
            throw new Exception("There is no constant of given name.");
        }
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public String toString() {
        if (value == 1) return "phi";
        else if (value == 2) return "e";
        else if (value == 3) return "pi";
        else return ""; //never to happen
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant constant = (Constant) o;
        return value == constant.value;
    }
}

package tests;
import structures.*;

public class Main {
    public static void main(String[] args) throws Exception{

        Pair[] pairs = {
        new Pair("a", 1),
        new Pair("b", 2),
        new Pair("c", 3),
        new Pair("d", 4),
        new Pair("e", 5),
        new Pair("f", 6),
        new Pair("g", 7),
        new Pair("h", 8)
        };

        DynamicArraySet dynamicSet = new DynamicArraySet();
        ArraySet staticSet = new ArraySet(8);

        for (Pair pair : pairs){
            dynamicSet.insert(pair);
            staticSet.insert(pair);
        }

        System.out.println("Testing Inserting");
        System.out.println(dynamicSet);
        System.out.println(staticSet);

        for (int i = 1; i < staticSet.count(); i++){
            dynamicSet.delete(pairs[i]);
            staticSet.delete(pairs[i]);
        }

        System.out.println("Testing Deleting");
        System.out.println(dynamicSet);
        System.out.println(staticSet);

        System.out.println("Testing Clean");
        staticSet.clean();
        dynamicSet.clean();
        System.out.println(dynamicSet);
        System.out.println(staticSet);

        System.out.println("Testing Search");
        System.out.println(staticSet.search("a"));
        System.out.println(dynamicSet.search("a"));

        System.out.println("Testing Read");
        System.out.println(staticSet.read(pairs[0]));
        System.out.println(dynamicSet.read(pairs[0]));

        System.out.println("Testing Edit");
        Pair p = new Pair("a", 2);
        staticSet.edit(p);
        dynamicSet.edit(p);
        System.out.println(dynamicSet);
        System.out.println(staticSet);

    }
}

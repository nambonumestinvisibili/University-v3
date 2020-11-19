import structures.OrderedList;

import java.util.Calendar;

public class Main {

    public static void main(String[] args){

        OrderedList<Integer> oli = new OrderedList<>(0);
        OrderedList<String> ols = new OrderedList<>("a");
        OrderedList<Calendar> olc = new OrderedList<>(Calendar.getInstance());



        Integer[] intElements = new Integer[] {3, 1, 2, 10, 5, 1};
        String[] stringElements = new String[] {"efg", "zxy", "zyx", "abc", "abb", "bcd"};
        Calendar calendar;

        for (int i = 0; i < 6; i++){
            oli.insert(intElements[i]);
            ols.insert(stringElements[i]);
            calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, 6-i);
            olc.insert(calendar);
        }

        System.out.println();
        System.out.println("Insertion");
        System.out.println(oli);

        System.out.println(oli);
        oli.insert(-1);
        System.out.println(oli);


        System.out.println(ols);
        System.out.println(olc);

        System.out.println();
        System.out.println("Removal");
        oli.remove(1);
        ols.remove("a");
        ols.remove("zyx");
        olc.remove(Calendar.getInstance());


        System.out.println(oli);
        System.out.println(ols);
        System.out.println(olc);

        System.out.println();
        System.out.println("Min oli, max oli, calendar at idx 1");
        System.out.println(oli.min());
        System.out.println(oli.max());
        System.out.println(olc.at(1));

        System.out.println();
        System.out.println("oli has 0?, ols has abb?");
        System.out.println(oli.search(0));
        System.out.println(ols.search("abb"));

        System.out.println();
        System.out.println("Calendar min");
        System.out.println(olc.min());

        System.out.println();
        System.out.println("index of 11 and 10 in oli");
        System.out.println(oli.index(11));
        System.out.println(oli.index(10));

    }
}

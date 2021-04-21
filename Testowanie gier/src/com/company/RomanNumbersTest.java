package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumbersTest {

    private boolean isOK(String romanNumber, int decimal){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        Integer[] integers = { 1, 4, 5,9,10,40,50,90,100,400,500,900,1000 };
        String[] strings = {"I","IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String ans = "";


            for (int i = integers.length-1; i >=0; i--){
                while (decimal >= integers[i]) {
                    ans += strings[i];
                    decimal -= integers[i];
                }
            }

            return ans.equals(romanNumber);
    }

    @Test
    void someF(){
        for (int i = 1; i < 4000 ; i++){
            String res = RomanNumbers.intToRoman(i);
            System.out.println(res + " " + i);
            assertTrue(isOK(res, i));

        }

    }
}
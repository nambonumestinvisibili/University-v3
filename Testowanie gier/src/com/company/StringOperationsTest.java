package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringOperationsTest {

    StringOperations sop = new StringOperations();

    @Test
    void validInputTest(){
        String letter = "d";
        List<String> listOfStrings = Arrays.asList("a", "b", "c", "d", "e");
        var resultList = sop.excludeStringFromList(
                listOfStrings, letter);
        assertFalse(resultList.contains(letter));
    }

    @Test
    void validInputWithListContainingNull() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(null);
        var res = sop.excludeStringFromList(list, "a");
        assertTrue(res.contains(null));
    }

    @Test
    void illegalInputTest(){

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           sop.excludeStringFromList(null, "a");
        });

        assertTrue(exception.getMessage().equals("List is null"));
    }


}
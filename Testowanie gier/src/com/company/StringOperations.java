package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringOperations {


    public List<String> excludeStringFromList(List<String> listOfStrings, String word){
        if (listOfStrings == null) throw new IllegalArgumentException("List is null");
        if (word == null) throw new IllegalArgumentException("Excluded word is null");
        return listOfStrings
                .stream()
                .filter(c -> {
                    if (c == null) return true;
                    else {
                        return !c.equals(word);
                    }
                })
                .collect(Collectors.toList());
    }

}

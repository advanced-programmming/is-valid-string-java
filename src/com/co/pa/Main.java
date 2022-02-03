package com.co.pa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
Input - a string of alphabet chars (like "aabbccddd", etc)

Function should calculate if it is valid.
Definition of valid string: 
- Condition 1. if all characters in string appears same number of times OR
- Condition 2. It will also be valid if after removal of 1 char from a string remaining characters will occur same number of times


In the above example "aabbccddd"
Number of "a"s -2
Number of "b"s - 2
Number of "c"s - 2
Number of "d"s - 3
String is valid because we can remove just one "d" and remaining characters a,b,c,d will occur same number of times - 2


Tasks: 
1) Create a method that will implement boolean isValid(String)
2) Write program that will test method with different tests */
public class Main {

    public static void main(String[] args) {
        String input  = ""; // <- put your input here :)
        System.out.println(isValid(input));
    }

    public static boolean isValid(String input){
        Set<Integer> counters = countCharacter(input);
        return validateCounters(counters);
    }

    /**
     * Only validate the size when is minor or equal to 2, if the size > 2, is false per default.
     * @param counters set
     * @return boolean
     */
    private static boolean validateCounters(Set<Integer> counters){
        boolean result = false;
        if (counters.size() == 2){
            List<Integer> values = counters.stream().collect(Collectors.toList());
            result = (values.get(1) - 1) == values.get(0) ? true : false;
        } else if (counters.size() < 2) result = true;

        return result;
    }

    private static Set<Integer>  countCharacter(String input){
        Set<Integer> setResult = new TreeSet<>();
        Map<Character, Integer> result = new HashMap<>();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(result.containsKey(c)) result.put(c, (result.get(c) + 1));
            else result.put(c, 1);
        } // with this counts character for storage in map

        setResult.addAll(result.values()); // send all values to set (TreeSet) to arrange the values, y delete duplicates.
        return setResult;

    }
}

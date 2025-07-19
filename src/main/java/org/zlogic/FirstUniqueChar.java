package org.zlogic;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar 
{

    public static String findFirstUniqueChar(String s) {
        if (s == null || s.isEmpty())
            return null;

        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        for(Character c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if(entry.getValue() == 1) {
                return String.valueOf(entry.getKey()); // will fail compilation because method signature returns String and this is a char
            }
        }

        return null;
    }

    public static String findFirstUniqueCharIgnoreCase(String s) {
        if (s == null || s.isEmpty())
            return null;

        s = s.toLowerCase();

        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        for(Character c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if(entry.getValue() == 1) {
                return String.valueOf(entry.getKey()); // will fail compilation because method signature returns String and this is a char
            }
        }

        return null;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

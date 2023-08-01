package javaexercices.string;
/*
Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri". The string length will be at least 2.


middleTwo("string") → "ri"
middleTwo("code") → "od"
middleTwo("Practice") → "ct"
 */
public class MiddleTwo {
    public String middleTwo(String str) {
        int len = str.length();
        int middleIndex = len / 2;
        return str.substring(middleIndex - 1 , middleIndex + 1);
    }

}

package javaexercices.string;
/*
Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. The string length will be at least 2.


left2("Hello") → "lloHe"
left2("java") → "vaja"
left2("Hi") → "Hi"
 */
public class Left2 {
    public String left2(String str) {
        String value = str.length() >= 2 ? str.substring(2) + str.substring(0,2) : str;
        return value;
    }
}

package javaexercices.string;
/*
Given a string, return a version without the first 2 chars. Except keep the first char if it is 'a' and keep the second char if it is 'b'. The string may be any length. Harder than it looks.


deFront("Hello") → "llo"
deFront("java") → "va"
deFront("away") → "aay"
 */
public class DeFront {
    public String deFront(String str) {
        StringBuilder result = new StringBuilder();

        if(str.length() >= 1 && str.charAt(0) == 'a') {
            result.append('a');
        }
        if(str.length() >= 2 && str.charAt(1) == 'b') {
            result.append('b');
        }
        if(str.length() > 2) {
            result.append(str.substring(2));
        }
        return result.toString();
    }
}

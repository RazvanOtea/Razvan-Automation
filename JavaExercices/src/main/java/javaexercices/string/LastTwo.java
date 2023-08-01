package javaexercices.string;
/*
Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding" yields "codign".


lastTwo("coding") → "codign"
lastTwo("cat") → "cta"
lastTwo("ab") → "ba"
 */
public class LastTwo {
    public String lastTwo(String str) {
        int len = str.length();
        if(len >= 2) {
            char lastChar = str.charAt(len - 1);
            char secondLastChar = str.charAt(len - 2);
            return str.substring(0, len - 2 ) + lastChar + secondLastChar;
        } else {
            return str;
        }
    }
}

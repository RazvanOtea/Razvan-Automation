package javaexercices.string;
/*
Given 2 strings, a and b, return a new string made of the first char of a and the last char of b, so "yo" and "java" yields "ya". If either string is length 0, use '@' for its missing char.


lastChars("last", "chars") → "ls"
lastChars("yo", "java") → "ya"
lastChars("hi", "") → "h@"

 */
public class LastChars {
    public String lastChars(String a, String b) {
        char firstCharA = (a.length() > 0) ? a.charAt(0) : '@';
        char lastCharB = (b.length() >0) ? b.charAt(b.length() - 1) : '@';
        return Character.toString(firstCharA) + Character.toString(lastCharB);
    }
}

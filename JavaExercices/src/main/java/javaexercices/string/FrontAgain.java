package javaexercices.string;
/*
Given a string, return true if the first 2 chars in the string also appear at the end of the string, such as with "edited".


frontAgain("edited") → true
frontAgain("edit") → false
frontAgain("ed") → true
 */
public class FrontAgain {
    public boolean frontAgain(String str) {
        if(str.length() >=2) {
            String firstTwoChars = str.substring(0,2);
            String lastTwoChars = str.substring(str.length() - 2);
            return firstTwoChars.equals(lastTwoChars);
        } else {
            return false;
        }
    }
}

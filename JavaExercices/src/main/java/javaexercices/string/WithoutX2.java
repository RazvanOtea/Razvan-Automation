package javaexercices.string;
/*
Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, and otherwise return the string unchanged. This is a little harder than it looks.


withoutX2("xHi") → "Hi"
withoutX2("Hxi") → "Hi"
withoutX2("Hi") → "Hi"
 */
public class WithoutX2 {
    public String withoutX2(String str) {
        if(str.length() == 0) {
            return "";
        } else if(str.length() == 1 ) {
            return str.charAt(0) != 'x' ? str : "";
        } else {
            char firstChar = str.charAt(0);
            char secondChar = str.charAt(1);

            if(firstChar == 'x' && secondChar == 'x') {
                return str.substring(2);
            } else if(firstChar == 'x') {
                return str.substring(1);
            } else if(secondChar == 'x') {
                return firstChar + str.substring(2);
            } else {
                return str ;
            }
        }
    }
}

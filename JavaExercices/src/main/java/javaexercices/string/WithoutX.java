package javaexercices.string;
/*
Given a string, if the first or last chars are 'x', return the string without those 'x' chars, and otherwise return the string unchanged.


withoutX("xHix") → "Hi"
withoutX("xHi") → "Hi"
withoutX("Hxix") → "Hxi"
 */
public class WithoutX {
    public String withoutX(String str) {
        int len = str.length();
        if(len > 0 && str.charAt(0) == 'x') {
            str = str.substring(1);
            len--;
        }
        if(len > 0 && str.charAt(len - 1) == 'x') {
            str = str.substring(0, len - 1);
        }
        return str;
    }
}

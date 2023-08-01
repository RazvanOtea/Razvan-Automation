package javaexercices.string;
/*
Given a string, return true if it ends in "ly".


endsLy("oddly") → true
endsLy("y") → false
endsLy("oddy") → false

 */
public class EndsLy {
    public boolean endsLy(String str) {
        if(str.endsWith("ly")) {
            return true;
        } else {
            return false;
        }
    }
}

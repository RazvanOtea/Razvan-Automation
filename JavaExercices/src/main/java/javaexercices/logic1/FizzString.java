package javaexercices.logic1;
/*
Given a string str, if the string starts with "f" return "Fizz". If the string ends with "b" return "Buzz". If both the "f" and "b" conditions are true, return "FizzBuzz". In all other cases, return the string unchanged. (See also: FizzBuzz Code)


fizzString("fig") → "Fizz"
fizzString("dib") → "Buzz"
fizzString("fib") → "FizzBuzz"
 */
public class FizzString {
    public String fizzString(String str) {
        boolean startsWithF = str.startsWith("f");
        boolean endsWithB = str.endsWith("b");
        if(startsWithF && endsWithB) {
            return  "FizzBuzz";
        }
        else if(startsWithF) {
            return "Fizz";
        }
        else if(endsWithB) {
            return "Buzz";
        }
        else {
            return str;
        }
    }
}

package javaexercices.array;
/*
Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. Both arrays will be length 1 or more.


commonEnd([1, 2, 3], [7, 3]) → true
commonEnd([1, 2, 3], [7, 3, 2]) → false
commonEnd([1, 2, 3], [1, 3]) → true
 */
public class CommonEnd {
    public boolean commonEnd(int[] a , int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        return a[0] == b[0] || a[aLength - 1] == b[bLength - 1];
    }
}

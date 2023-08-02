package javaexercices.array;
/*
Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.


firstLast6([1, 2, 6]) → true
firstLast6([6, 1, 2, 3]) → true
firstLast6([13, 6, 1, 2, 3]) → false
 */
public class FirstLast6 {
    public boolean firstLast6(int[] nums) {
        int firstElement = nums[0];
        int lastElement = nums[nums.length - 1];
        return firstElement == 6 || lastElement == 6;
    }
}

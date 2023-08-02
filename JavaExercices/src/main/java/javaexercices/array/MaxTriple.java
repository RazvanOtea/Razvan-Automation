package javaexercices.array;
/*
Given an array of ints of odd length, look at the first, last, and middle values in the array and return the largest. The array length will be a least 1.


maxTriple([1, 2, 3]) → 3
maxTriple([1, 5, 3]) → 5
maxTriple([5, 2, 3]) → 5
 */
public class MaxTriple {
    public int maxTriple(int[] nums) {
        int length = nums.length;
        int firstNumber = nums[0];
        int middleNumber = nums[length / 2];
        int lastNumber = nums[length - 1 ];
        int max = firstNumber;
        if(middleNumber > max) {
            max = middleNumber;
        }
        if(lastNumber > max) {
            max = lastNumber;
        }
        return max;
    }
}

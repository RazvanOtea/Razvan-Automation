package javaexercices.array;

import java.util.Arrays;
import java.util.Collections;

/*
Given an array of ints length 3, return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}.


reverse3([1, 2, 3]) → [3, 2, 1]
reverse3([5, 11, 9]) → [9, 11, 5]
reverse3([7, 0, 0]) → [0, 0, 7]
 */
public class Reverse3 {
    public int[] reverse3(int[] nums) {
        int aux;
        for(int i =0; i < nums.length / 2; i++) {
            aux = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = aux;
        }
        return nums;
    }
}

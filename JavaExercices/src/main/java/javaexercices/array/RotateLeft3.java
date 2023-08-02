package javaexercices.array;
/*
Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.


rotateLeft3([1, 2, 3]) → [2, 3, 1]
rotateLeft3([5, 11, 9]) → [11, 9, 5]
rotateLeft3([7, 0, 0]) → [0, 0, 7]
 */
public class RotateLeft3 {
    public int[] rotateLeft3(int[] nums) {
        int[] rotatedArray = new int[nums.length];
        rotatedArray[0] = nums[1];
        rotatedArray[1] = nums[2];
        rotatedArray[2] = nums[0];
        return rotatedArray;
        }
    }

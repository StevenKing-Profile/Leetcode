package array.easy.twoPointers;

import java.util.Arrays;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
*/
public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[] { 0,1,0,3,12 });
        moveZeroes(new int[] { 0 });
    }

    public static void moveZeroes(int[] nums) {
        int aPointer = 0; // array index
        int bPointer = 0; // search through array

        while (bPointer < nums.length) {
            if (nums[bPointer] != 0) {
                nums[aPointer] = nums[bPointer];
                aPointer++;
            }

            bPointer++;
        }

        for (int i=aPointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

//    public static void moveZeroes(int[] nums) {
//        int index = 0;
//        for (int i=0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[index] = nums[i];
//                index++;
//            }
//        }
//
//        for (int i=index; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }
}

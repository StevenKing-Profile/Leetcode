package array.medium;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/
public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{ 1, 2, 3, 4, 5, 6, 7 }, 3);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length; // because length of array can be less than k

        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, nums.length-1); // rotate entire array
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, k-1); // rotate the amount from 0 through k
        System.out.println(Arrays.toString(nums));
        reverse(nums, k, nums.length-1); // rotate everything else
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // n^2 Approach
//    public static void rotateN2(int[] nums, int k) {
//        for (int i=0; i < k; i++) {
//            int pointer = nums[0];
//
//            for (int j=0; j < nums.length; j++) {
//                if (j == 0) {   // placing last element on front
//                    nums[0] = nums[nums.length - 1];
//                } else {    // push everything else to the right
//                    int temp = nums[j];
//                    nums[j] = pointer;
//                    pointer = temp;
//                }
//            }
//        }
//    }
}

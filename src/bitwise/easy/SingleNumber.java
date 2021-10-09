package bitwise.easy;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
    Input: nums = [2,2,1]
    Output: 1

Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

Example 3:
    Input: nums = [1]
    Output: 1
*/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{ 2, 2, 1 }));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = result ^ num;  // XOR = treat numbers as bits. If you XOR two of the same bits, it returns 0. So this returns unique number.
        }

        return result;
    }
}

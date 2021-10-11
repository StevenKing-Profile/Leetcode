package array.easy;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
    Input: nums = [1,2,3,1]
    Output: true

Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true
*/
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{ 1,1,1,3,3,4,3,2,4,2 }));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            if (s.contains(num)) {
                return true;
            } else {
                s.add(num);
            }
        }

        return false;
    }
}

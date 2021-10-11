package array.easy;

import java.util.*;
import java.util.stream.Collectors;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Explanation: [4,9] is also accepted.
*/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{ 4,9,5 }, new int[]{ 9,4,9,8,4 })));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();

        for (int i : nums1) {
            if (!s.contains(i)) {
                for (int j : nums2) {
                    if (i == j) {
                        s.add(i);
                    }
                }
            }
        }

        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}

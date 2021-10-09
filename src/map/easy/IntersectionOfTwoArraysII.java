package map.easy;

import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
*/
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{ 1,2,2,1 }, new int[]{ 2,2 })));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();

        for (int num : map1.size() < map2.size() ? map1.keySet() : map2.keySet()) {
            if (map1.containsKey(num) && map2.containsKey(num)) {
               for (int j=0; j < (map1.get(num) < map2.get(num) ? map1.get(num) : map2.get(num)); j++) {
                   resultList.add(num);
               }
            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}

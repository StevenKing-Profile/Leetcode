package array.medium.permutations;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]
 */
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[]{ 1,2,3 });

        for (List<Integer> innerList : list) {
            System.out.println(innerList.toString());
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i=start; i < nums.length; i++) {
                swap(i, start, nums);
                backtrack(result, nums, start+1);
                swap(i, start, nums);
            }
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
        public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i=0; i < nums.length; i++) {
                if (!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
     */
}

package array.medium;

import java.util.Arrays;

/*
Given an array of integers nums, sort the array in ascending order.

Example 1:
    Input: nums = [5,2,3,1]
    Output: [1,2,3,5]
*/
public class SortIntArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{ 5, 2, 3, 1 })));
    }

    public static int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1); // Average-case analysis = O(n log n)
        return nums;
    }

    // recursively call
        // split everything into subarrays and begin sorting
    private static void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quicksort(nums, left, index-1);
            quicksort(nums, index+1, right);
        }
    }

    // 1. Pick a pivot element
        // (we can technically choose whatever but middle is a safe choice)
    // 2. Anything less than the pivot, we put before the pivot and larger after the pivot
        // We accomplish this by diving the list in half and eventually swapping positions
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left + (right-left) / 2];

        while (left <= right) {
            while (nums[left] < pivot) { // check if element to the left is less than the pivot
                left++;
            }

            while (nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Java method call
//    public static int[] sortArrayFunction(int[] nums) {
//        Arrays.sort(nums);
//        return nums;
//    }
}

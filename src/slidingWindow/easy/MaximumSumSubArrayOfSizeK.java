package slidingWindow.easy;

/*
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:
    Input: [2, 1, 5, 1, 3, 2], k=3
    Output: 9
    Explanation: Subarray with maximum sum is [5, 1, 3].
*/
public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray_BruteForce(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(findMaxSumSubArray_SlidingWindow(3, new int[]{2, 1, 5, 1, 3, 2}));
    }

    // Time Complexity: O(N), Space Complexity: O(1)
    public static int findMaxSumSubArray_SlidingWindow(int k, int[] arr) {
        int temp = 0;
        int result = -1;
        int start = 0;

        for (int end=0; end < arr.length; end++) {
            temp += arr[end];
            if (end >= k - 1) {
                result = Math.max(temp, result);
                temp -= arr[start];
                start++;
            }
        }

        return result;
    }

    // Time Complexity: O(N*K), Space Complexity O(1)
    public static int findMaxSumSubArray_BruteForce(int k, int[] arr) {
        int result = -1;

        for (int i=0; i < arr.length - k; i++) {
            int tempTotal = 0;
            for (int j = i; j < i + k; j++) {
                tempTotal += arr[j];
            }
            result = Math.max(result, tempTotal);
        }

        return result;
    }
}

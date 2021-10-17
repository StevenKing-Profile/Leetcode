package slidingWindow.easy;

/*
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:
    Input: [2, 1, 5, 2, 3, 2], S=7
    Output: 2
    Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 */
public class SmallestSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{ 2,1,5,2,3,2 }));
    }

    public static int findMinSubArray(int S, int[] arr) {
        int temp = 0;
        int result = arr.length;
        int startWindow = 0;

        /*
            The outer for loop runs for all elements, and the inner while loop processes each element only once O(N + N) = O(N)
         */
        // Time Complexity: O(N), Space Complexity O(1)
        /*
            2
            2,1
            2,1,5
                result = (2 - 0) + 1 = 3
                temp = 1,5
                startWindow = 1
            1,5,2
                result = 3 - 1 + 1 = 3
                temp = 5,2
                startWindow = 2

                (STILL equal to 7)

                result = 3 - 2 + 1 = 2
                temp = 2
                startWindow = 3
        */
        for (int endWindow=0; endWindow < arr.length; endWindow++) {
            temp += arr[endWindow];

            while (temp >= S) {
                result = Math.min(result, (endWindow - startWindow) + 1);
                temp -= arr[startWindow];
                startWindow++;
            }
        }

        return result == arr.length ? 0 : result;
    }
}

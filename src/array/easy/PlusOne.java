package array.easy;

import java.util.Arrays;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

Example 1:
    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124. Thus, the result should be [1,2,4].
*/
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
        System.out.println(Arrays.toString(plusOne(new int[] { 8,9,9,9 })));
        System.out.println(Arrays.toString(plusOne(new int[] { 9,9 })));
    }

    public static int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            if (digits[0] == 9)
                return new int[]{ 1,0 };
            else
                return new int[] { digits[0] + 1 };
        }

        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] arrayCarriedOver = new int[digits.length + 1];
        arrayCarriedOver[0] = 1;
        for (int i=0; i < digits.length; i++) {
            arrayCarriedOver[i+1] = digits[i];
        }

        return arrayCarriedOver;
    }
}

package string.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseAString {
    public static void main(String[] args) {
        System.out.println(reverseAString("foobar"));
    }

    private static String reverseAString(String str) {
        char[] arr = str.toCharArray();
        int end = arr.length - 1;

        for (int i=0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i]= arr[end];
            arr[end] = temp;
            end--;
        }

        return String.valueOf(arr);
    }
}

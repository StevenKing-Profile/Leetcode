package array.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given an array of randomly arranged lower case letters, uppercase letters, and numbers, sort the array such that
lowercase -> uppercase -> numbers. The classes of characters do not need to be in order in their respective sections.
*/
public class SortArrayUpperLowerNumbers {
    public static void main(String[] args) {
        sortLowerUpperNumber(new String[]{"foo", "Bar", "Tacocat", "bananna", "Apple", "cat", "Zleaners", "1", "9", "6", "0" });
    }

    private static void sortListFunction(String[] arr) {
        List<String> list = Arrays.stream(arr).collect(Collectors.toList());
        list.sort(Comparator.comparing(str -> str.charAt(0) < 'a')); // Comparator
    }

    private static void sortLowerUpperNumber(String[] arr) {
        int counter = 0;
        String[] result = new String[arr.length];

        for (int i=0; i < arr.length; i++) {
            if ((int) arr[i].charAt(0) > 97 && (int) arr[i].charAt(0) < 122) {
                result[counter] = arr[i];
                counter++;
            }
        }

        for (int i=0; i < arr.length; i++) {
            int value = arr[i].charAt(0);
            if (value >= 65 && value <= 90) {
                result[counter] = arr[i];
                counter++;
            }
        }

        for (int i=0; i < arr.length; i++) {
            int value = arr[i].charAt(0);
            if (value >= 48 && value <= 57) {
                result[counter] = arr[i];
                counter++;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}

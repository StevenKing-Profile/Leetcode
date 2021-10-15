package array.medium.permutations;

import java.util.*;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").
*/
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
        System.out.println(checkInclusion("abcdxabcde", "abcdeabcdx"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int a_pointer = 0;
        int b_pointer = 0;

        List<Character> tempList = new ArrayList<>();

        while (b_pointer < s2.length() || tempList.size() == s1.length()) {
            if (tempList.size() == s1.length()) {
                for (int i=0; i < s1.length(); i++) {
                    if (tempList.contains(s1.charAt(i))) {
                        tempList.remove((Character) s1.charAt(i));
                    } else {
                        break;
                    }
                }

                if (tempList.size() == 0)
                    return true;

                a_pointer++;
                b_pointer = a_pointer;
                tempList.clear();
            } else {
                tempList.add(s2.charAt(b_pointer));
                b_pointer++;
            }
        }

        return false;
    }
}

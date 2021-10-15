package string.medium;

import java.util.ArrayList;
import java.util.List;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
 original letters exactly once.

Example 1:
    Input: s = "cbaebabacd", p = "abc"
    Output: [0,6]
    Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".
*/

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        List<Character> tempList = new ArrayList<>();
        int a_pointer = 0;
        int b_pointer = 0;

        while(b_pointer < s.length() || tempList.size() == p.length()) {
            if (tempList.size() == p.length()) {
                boolean isValid = true;

                for (int i=0; i < p.length(); i++) {
                    if (!tempList.contains(p.charAt(i))) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid)
                    result.add(a_pointer);

                a_pointer++;
                b_pointer = a_pointer;
                tempList.clear();
            } else {
                tempList.add(s.charAt(b_pointer));
                b_pointer++;
            }
        }

        return result;
    }
}

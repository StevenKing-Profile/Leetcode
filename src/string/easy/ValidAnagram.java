package string.easy;

import java.util.HashMap;
import java.util.Map;

/*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true
*/
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();

        for (int i=0; i < s.length(); i++) {
            if (m1.containsKey(s.charAt(i))) {
                m1.replace(s.charAt(i), m1.get(s.charAt(i)) + 1);
            } else
                m1.put(s.charAt(i), 1);
        }

        for (int i=0; i < t.length(); i++) {
            if (m1.containsKey(t.charAt(i))) {
                if (m1.get(t.charAt(i)) > 1) {
                    m1.put(t.charAt(i), m1.get(t.charAt(i)) - 1);
                } else {
                    m1.remove(t.charAt(i));
                }
            } else {
                return false;
            }
        }

        return true;
    }
}

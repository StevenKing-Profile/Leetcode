package palindrome.easy;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, determine if a permutation of the string could form a palindrome.
Example:
    "code" -> False,
    "aab" -> True,
    "carerac" -> True.
*/
public class PalindromePermutations {
    public static void main(String[] args) {
        String s = "carerac";
        System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (int i=0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }

        return set.size() <= 1 ? true : false;
    }
}
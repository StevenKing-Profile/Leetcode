package palindrome.easy;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutations {
    public static void main(String[] args) {
        String s = "rasdfgcr";
        System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i=0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), 0);
        }

        for (char key : map.keySet()) {
            count += map.get(key) % 2;
        }

        return count <= 1;
    }
}
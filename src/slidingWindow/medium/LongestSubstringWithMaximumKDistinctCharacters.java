package slidingWindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaximumKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 9));
    }

    // Time Complexity: O(N+N), Space Complexity: O(K+1)
    public static int findLength(String str, int k) {
        int result = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (map.size() > k) {
                char leftChar = str.charAt(start);

                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                start++;
            }
            result = Math.max(result, i - start + 1);
        }

        return result;
    }

    // semi Brute because we could just do i - start + 1
    public static int findLength_SemiBrute(String str, int k) {
        int result = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

            while (map.size() > k) {
                map.remove(str.charAt(start));
                start++;
            }

            int temp = 0;
            for (char c : map.keySet()) {
                temp += map.get(c);
            }

            result = Math.max(result, temp);
        }

        return result;
    }
}

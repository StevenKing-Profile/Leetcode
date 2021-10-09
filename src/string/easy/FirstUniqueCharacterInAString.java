package string.easy;

/* tacovcat */

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {

    }

    public static int twoPointersApproach(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (left < i && map.get(s.charAt(left)) > 1) {
                left++;
            }
        }

        return map.get(s.charAt(left)) == 1 ? left : -1;
    }
}

/*
    pointer 1 will be the last digit we've seen
    pointer 2 will track ahead of the array
 */
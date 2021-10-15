package palindrome.easy;

/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
*/
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }

    public static boolean isPalindrome(int x) {
        String str = x + "";

        int b_pointer = str.length() - 1;
        for (int i=0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(b_pointer)) {
                return false;
            }
            b_pointer--;
        }

        return true;
    }
}

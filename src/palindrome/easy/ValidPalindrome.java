package palindrome.easy;

/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*/

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        String formattedStr = format(s);

        int b_pointer = formattedStr.length() - 1;
        for (int i=0; i < formattedStr.length()/2; i++) {
            if (formattedStr.charAt(i) != formattedStr.charAt(b_pointer))
                return false;

            b_pointer--;
        }

        return true;
    }

    public static String format(String inputStr) {
        String formattedStr = "";

        inputStr = inputStr.toLowerCase();

        for (int i=0; i < inputStr.length(); i++) {
            if (('a' <= (int) inputStr.charAt(i) && 'z' >= (int) inputStr.charAt(i)) || ('0' <= (int) inputStr.charAt(i) && '9' >= (int) inputStr.charAt(i)))
                formattedStr += inputStr.charAt(i);
        }

        return formattedStr;
    }
}

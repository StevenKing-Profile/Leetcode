package recursion.easy;

/*
Example 3:
    Input: n = 4    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
*/
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println(fibIterative(4));
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        else
            return fib(n-1) + fib(n-2);
    }

    public static int fibIterative(int n) {
        int temp; // previous, previous
        int prev = 0;
        int curr = 1;

        for (int i=1; i < n; i++) {
            temp = prev;
            prev = curr;
            curr = temp + prev;
        }

        return curr;
    }
}

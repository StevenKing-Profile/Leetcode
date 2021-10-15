package recursion.medium;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
*/
public class MinimumCoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int coinCount = -1;

        for (int coinValue : coins) {
            int remainder = coinChange(coins, amount - coinValue);

            if (remainder >= 0) {
                if (coinCount == -1)
                    coinCount = remainder + 1; // +1 because we can't have the negative
                else
                    coinCount = Math.min(coinCount, remainder + 1); // +1 because it counts as a coin
            }
        }

        return coinCount;
    }
}

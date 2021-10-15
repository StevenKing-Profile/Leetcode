package array.easy;

/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with correct change, or false otherwise.
*/
public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{ 5,5,5,10,20 }));
        System.out.println(lemonadeChange(new int[]{ 5,5,10,10,20 }));
        System.out.println(lemonadeChange(new int[]{ 10,10 }));
    }

    public static boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;

        for (int bill : bills) {
            if (bill == 5)
                fiveCount++;
            else if (bill == 10) {
                if (fiveCount > 0) {
                    tenCount++;
                    fiveCount--;
                } else
                    return false;
            } else {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3)
                    fiveCount -= 3;
                else
                    return false;
            }
        }

        return true;
    }
}

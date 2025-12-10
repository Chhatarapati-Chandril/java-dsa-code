// We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
// Find min no. of coins/notes to make change for a value V.

import java.util.*;

public class V9_Coins {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // sort in DESC order
        Arrays.sort(coins, Comparator.reverseOrder());

        int amount = 1059;
        int countOfCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
                while(coins[i] <= amount){
                    ++countOfCoins;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
        }
        System.out.println("Total (min) coins used: " + countOfCoins);
        System.out.println("Coins used: " + ans);
    }
}
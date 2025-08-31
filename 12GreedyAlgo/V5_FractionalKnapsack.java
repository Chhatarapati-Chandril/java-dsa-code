// Given the weights and values of 'N' items,
// put these items in a knapsack of capacity(max weight) 'W',
// to get the maximum total value in knapsack

import java.util.*;

public class V5_FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        // 0th col => original index
        // 1st col => ratio

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // desc order on basis of ratio
        Arrays.sort(ratio, Comparator.comparingDouble((double[] o) -> o[1]).reversed());

        int capacity = W;
        int finalVal = 0;

        for (int i = 0; i < ratio.length; i++) {
            int idx = (int) ratio[i][0];

            // include full item
            if(capacity >= weight[idx]){
                finalVal += val[idx];
                capacity -= weight[idx];
            }
            // include partial item
            else{
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value: " + finalVal);
    }
}
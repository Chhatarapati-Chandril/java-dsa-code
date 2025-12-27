// Stock Profit Maximization Problem

// You are given an array prices where prices[i] is the price of a given stock on the i-th day. 
// You want to maximize your profit by choosing a single day to buy one stock 
// and choosing a different day in the future to sell that stock.

// Task: Return the maximum profit you can achieve from this transaction. 
// If you cannot achieve any profit, return 0.


public class stocks
{
    public static int stock(int price[])
    { 
       int buyprice=price[0];
       int maxprofit=0;
       for (int i=1;i<price.length;i++)
       {
            if (buyprice<price[i])
            {
                int currprofit=price[i]-buyprice;
                maxprofit=Math.max(maxprofit,currprofit);
            }
            else 
            {
                buyprice=price[i];
            }
       }
       return maxprofit;
    }
    public static void main(String args[])
    {
        int price[]={1,2,3,4,5,6,7,8,9};
        System.out.println(stock(price));
    }
}
package my.ds.problems;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

public class BuySellStock {

    public static int maxProfit(int[] prices) {
        int minIndex=0, maxValue=0;
        for(int i=1;i<prices.length; i++){
            maxValue = Math.max(maxValue, prices[i]-prices[minIndex]);// Math.max(prices[i]-prices[i-1], prices[i]-prices[minIndex]));
            if(prices[minIndex] > prices[i]){
                minIndex = i;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2}));
        System.out.println(maxProfit(new int[]{2,1}));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BnSI {
    public int maxProfit(int[] prices) {
        int greater=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>greater) max=Math.max(max,prices[i]-greater);
            else greater=prices[i];
        }
        return max;
    }
}

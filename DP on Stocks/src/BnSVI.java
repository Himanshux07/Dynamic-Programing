//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class BnSVI {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];
        return solve(0,1,prices,dp,fee);
    }

    int solve(int idx,int buy,int[] prices,Integer[][] dp,int fee) {
        if (idx==prices.length) return 0;
        if (dp[idx][buy]!=null) return dp[idx][buy];

        if (buy==1){
            int buyIt=-prices[idx]+solve(idx+1,0,prices,dp,fee);
            int skip=solve(idx+1,1,prices,dp,fee);
            return dp[idx][buy]=Math.max(buyIt,skip);
        }
        else{
            int sellIt=prices[idx]-fee+solve(idx+1,1,prices,dp,fee);
            int skip=solve(idx+1,0,prices,dp,fee);
            return dp[idx][buy]=Math.max(sellIt,skip);
        }
    }
}

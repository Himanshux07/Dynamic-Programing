//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

public class BnSV {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return solve(0, 1, prices, dp);
    }

    int solve(int idx, int buy, int[] prices, Integer[][] dp) {
        if (idx >= prices.length) return 0;

        if (dp[idx][buy] != null) return dp[idx][buy];

        if (buy == 1) {
            int buyIt = -prices[idx] + solve(idx + 1, 0, prices, dp);

            int skip = solve(idx + 1, 1, prices, dp);
            return dp[idx][buy] = Math.max(buyIt, skip);
        }
        else{

            int sellIt = prices[idx] + solve(idx + 2, 1, prices, dp);

            int skip = solve(idx + 1, 0, prices, dp);
            return dp[idx][buy] = Math.max(sellIt, skip);
        }
    }
}

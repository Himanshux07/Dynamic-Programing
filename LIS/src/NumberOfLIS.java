//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

import java.util.Arrays;

public class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int [] cnt= new int[n];
        Arrays.fill(cnt,1);
        int maxLis=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        cnt[i]=cnt[j];
                    }
                    else if(dp[j]+1==dp[i]){
                        cnt[i]+=cnt[j];
                    }
                }
            }
            maxLis=Math.max(maxLis,dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLis) ans+=cnt[i];
        }
        return ans;
    }
}

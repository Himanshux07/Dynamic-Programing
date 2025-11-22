public class LongestIncresingSubsequence {

    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        Integer[][] dp=new Integer[n][n+1];
        return memo(0,-1,nums,dp);
    }
    //memoization
    int memo(int idx,int prev,int[] nums,Integer[][] dp){
        if(idx==nums.length) return 0;

        if(dp[idx][prev+1]!=null) return dp[idx][prev+1];

        int notTake=memo(idx+1,prev,nums,dp);

        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take=1+memo(idx+1,idx,nums,dp);
        }

        return dp[idx][prev+1]=Math.max(take,notTake);
    }
    //tabulation
    static int tabu(int [] arr){
        int n=arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int idx=n-1;idx>=0;idx--){
            for(int prev=idx-1;prev>=-1;prev--){
                int notTake=dp[idx+1][prev+1];

                int take=0;
                if(prev==-1 || arr[idx]>arr[prev]){
                    take=1+dp[idx+1][idx+1];
                }
                dp[idx][prev+1]=Math.max(take,notTake);
            }
        }
        return dp[0][-1+1];
    }
}

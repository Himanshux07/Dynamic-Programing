import java.util.Arrays;

public class HouseRob {

    //memoization
    int helper(int n,int[] arr,int[]dp){
        if(n==0) return arr[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int pick=helper(n-2,arr,dp) + arr[n];
        int notpick=helper(n-1,arr,dp);

        return dp[n]=Math.max(pick,notpick);
    }

    // recursive
    int helper(int n,int[] arr){
        if(n==0) return arr[n];
        if(n<0) return 0;

        int pick=helper(n-2,arr) + arr[n];
        int notpick=helper(n-1,arr);

        return Math.max(pick,notpick);
    }

    //tabulation
    int tab(int n,int[] arr){
        int [] dp = new int[n+1];
        dp[0]=arr[0];
        int neg=0;
        for(int i=1;i<=n;i++){
            int pick=arr[i];
            if(i>1) pick+=dp[i-2];
            int notpick=dp[i-1];

            dp[i]=Math.max(pick,notpick);
        }
        return dp[n];
    }

    // space optimization;
    int spaceopt(int n,int[] arr){

        int prev=arr[0];
        int prev2=0;
        for(int i=1;i<=n;i++){
            int pick=arr[i]+prev2;
            int notpick=prev;

            int curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n=nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,nums,dp);
    }
}

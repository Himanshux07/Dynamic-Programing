//https://leetcode.com/problems/burst-balloons/description/
public class BurstBalloon {
    Integer [][] dp;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        dp = new Integer[n+1][n+1];
        int [] arr= new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        return memo(1,n,arr);
    }
    int memo(int i,int j,int [] arr){
        if(i>j) return 0;
        if (dp[i][j]!=null) return dp[i][j];
        int ans=(int)(-1e9);
        for(int k=i;k<=j;k++){
            int cost=arr[i-1]*arr[k]*arr[j+1]+memo(i,k-1,arr)+memo(k+1,j,arr);
            ans=Math.max(ans,cost);
        }
        return dp[i][j]=ans;
    }
}

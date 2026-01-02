import java.util.Arrays;

public class MCM {
    //recursion way
    static int rec(int i,int j,int[] arr){
        if(i==j) return 0;
        int ans=(int)1e9;
        for(int k=i;k<=j-1;k++){
            int steps=arr[i-1]*arr[k]*arr[j]+rec(i,k,arr)+rec(k+1,j,arr);
            ans=Math.min(ans,steps);
        }
        return ans;
    }

    //memoization
    static int memo(int i,int j,int[] arr,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=(int)1e9;
        for(int k=i;k<=j-1;k++){
            int steps=arr[i-1]*arr[k]*arr[j]+memo(i,k,arr,dp)+memo(k+1,j,arr,dp);
            ans=Math.min(ans,steps);
        }
        return dp[i][j]=ans;
    }
    public static void main(String[] args) {
        System.out.println(rec(1,4,new int[]{10,20,30,40,50}));
        int[][] dp = new int[5][5];
        for(int i=0;i<5;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(memo(1,4,new int[]{10,20,30,40,50},dp));
    }
}

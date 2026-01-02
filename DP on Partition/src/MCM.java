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

    //tabulation
    static int tabu(int arr[]){
        int n=arr.length;
        int [][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]=0;

        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int ans=(int)1e9;
                for(int k=i;k<=j-1;k++){
                    int steps=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    ans=Math.min(ans,steps);
                }
                dp[i][j]=ans;
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        System.out.println(rec(1,4,new int[]{10,20,30,40,50}));
        int[][] dp = new int[5][5];
        for(int i=0;i<5;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(memo(1,4,new int[]{10,20,30,40,50},dp));
        System.out.println(tabu(new int[]{10,20,30,40,50}));
    }
}

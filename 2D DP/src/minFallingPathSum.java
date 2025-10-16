import java.util.Arrays;

public class minFallingPathSum {
    int n;
    int m;
    public int minPathSum(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        int [][]dp = new int[n][m];
        for(int j=0;j<m;j++){
            Arrays.fill(dp[j],-1);
        }
        for(int j=0;j<m;j++){
            ans=Math.min(ans,helper(matrix,n-1,j,dp));
        }
        return ans;
    }
    // Recursive

    // Memoization
    int helper(int [][] arr,int i,int j,int [][] dp){
        if(j<0 || j>=m) return (int)1e9;
        if(i==0) return arr[i][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int up=helper(arr,i-1,j,dp);
        int upl=helper(arr,i-1,j-1,dp);
        int upr=helper(arr,i-1,j+1,dp);

        return dp[i][j]=arr[i][j]+Math.min(up,Math.min(upl,upr));
    }
}

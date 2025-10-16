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
            ans=Math.min(ans,memo(matrix,n-1,j,dp));
        }
        return ans;
    }
    // Recursive
    int rec(int [][] arr,int i,int j){
        if(j<0 || j>=m) return (int)1e9;
        if(i==0) return arr[i][j];

        int up=rec(arr,i-1,j);
        int upl=rec(arr,i-1,j-1);
        int upr=rec(arr,i-1,j+1);

        return arr[i][j]+Math.min(up,Math.min(upl,upr));
    }
    // Memoization
    int memo(int [][] arr,int i,int j,int [][] dp){
        if(j<0 || j>=m) return (int)1e9;
        if(i==0) return arr[i][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int up=memo(arr,i-1,j,dp);
        int upl=memo(arr,i-1,j-1,dp);
        int upr=memo(arr,i-1,j+1,dp);

        return dp[i][j]=arr[i][j]+Math.min(up,Math.min(upl,upr));
    }

    //tabulation
    public int tabu(int [][] matrix){
        int n=matrix.length,m=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        int[][] dp=new int[n][m];
        for(int j=0;j<m;j++)dp[0][j]=matrix[0][j];
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=dp[i-1][j];
                int upl=j>0?dp[i-1][j-1]:(int)1e9;
                int upr=j<m-1?dp[i-1][j+1]:(int)1e9;
                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(upl,upr));
            }
        }
        for(int j=0;j<m;j++)ans=Math.min(ans,dp[n-1][j]);
        return ans;
    }
}

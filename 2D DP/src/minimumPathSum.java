public class minimumPathSum {
    // memoization
    public static int memo(int [][] grid,int i,int j,int [][]dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=grid[i][j]+memo(grid,i,j-1,dp);
        int right=grid[i][j]+memo(grid,i-1,j,dp);

        return dp[i][j]=Math.min(left,right);
    }
}

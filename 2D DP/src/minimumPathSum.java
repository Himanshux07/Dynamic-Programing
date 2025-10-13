public class minimumPathSum {

    //recursion
    public static int recur(int[][] grid,int i,int j){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)1e9;

        int left=grid[i][j]+recur(grid,i,j-1);
        int right=grid[i][j]+recur(grid,i-1,j);

        return Math.min(left,right);
    }

    // memoization
    public static int memo(int [][] grid,int i,int j,int [][]dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=grid[i][j]+memo(grid,i,j-1,dp);
        int right=grid[i][j]+memo(grid,i-1,j,dp);

        return dp[i][j]=Math.min(left,right);
    }

    //Tabulation
    public static int tabu(int [][]grid){
        int n=grid.length;
        int m=grid[0].length;
        int [][] dp= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) {
                    dp[i][j]=grid[i][j];
                    continue;
                }
                int left=(int)1e9;
                int right=(int)1e9;
                if(j>0) left=dp[i][j-1];
                if(i>0) right=dp[i-1][j];
                dp[i][j]=grid[i][j]+Math.min(left,right);
            }
        }
        return dp[n-1][m-1];
    }
}

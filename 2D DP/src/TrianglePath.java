import java.util.List;

public class TrianglePath {

    // Recursive
    static int rec(int [][] arr,int i,int j){
        if(i==arr.length-1) return arr[i][j];

        int down =arr[i][j]+rec(arr,i+1,j);
        int diagonal=arr[i][j]+rec(arr,i+1,j+1);

        return Math.min(down, diagonal);
    }

    //memoization
    static int memo(int [][] arr,int i,int j,int[][]dp){
        if(i==arr.length-1) return arr[i][j];
        if(dp[i][j]!=-1) return dp[i][j];

        int down=arr[i][j]+memo(arr,i+1,j,dp);
        int diagonal=arr[i][j]+memo(arr,i+1,j+1,dp);

        return dp[i][j]=Math.min(down,diagonal);
    }

    //Tabulation
    public int tabu(List<List<Integer>> triangle){
        int n=triangle.size();
        int[][] dp=new int[n][n];

        for(int j=0;j<n;j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int down=triangle.get(i).get(j)+dp[i+1][j];
                int diag=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down,diag);
            }
        }
        return dp[0][0];
    }
}

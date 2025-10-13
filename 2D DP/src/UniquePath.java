public class UniquePath {
    //recursive
    static int recur(int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0) return 0;

        int left=recur(i,j-1);
        int right=recur(i-1,j);

        return left+right;
    }

    //memoization
    static int memo(int i,int j,int [][]dp){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=recur(i,j-1);
        int right=recur(i-1,j);

        return dp[i][j]=left+right;
    }
    //tabulation
    public int tabu(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    int up=(i>0)?dp[i-1][j]:0;
                    int left=(j>0)?dp[i][j-1]:0;
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    //Space Optimization
    public int val(int m,int n){
        int [] prev=new int[n];
        for(int i=0;i<m;i++){
            int [] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) temp[j]=1;
                else{
                    temp[j]=prev[j]+temp[j-1];
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}

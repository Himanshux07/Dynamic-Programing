import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/description/
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int [][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,t,n-1,m-1,dp);
    }
    int helper(String s1,String s2,int i,int j,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=helper(s1,s2,i-1,j-1,dp) + helper(s1,s2,i-1,j,dp);
        }
        return dp[i][j]=helper(s1,s2,i-1,j,dp);
    }
}

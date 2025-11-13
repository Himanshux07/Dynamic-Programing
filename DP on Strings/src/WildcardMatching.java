//https://leetcode.com/problems/wildcard-matching/description/
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean [][] dp = new Boolean[m][n];
        return helper(p,s,m-1,n-1,dp);
    }
    boolean helper(String s1,String s2,int i,int j,Boolean [][] dp){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(i>=0 && j<0){
            for(int k=0;k<=i;k++){
                if(s1.charAt(k)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            return dp[i][j]=helper(s1,s2,i-1,j-1,dp);
        }
        if(s1.charAt(i)=='*'){
            return dp[i][j]=helper(s1,s2,i-1,j,dp) || helper(s1,s2,i,j-1,dp);
        }
        return dp[i][j]=false;
    }

}

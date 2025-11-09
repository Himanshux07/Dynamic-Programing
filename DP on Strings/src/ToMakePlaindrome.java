// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class ToMakePlaindrome {
    public int minInsertions(String s) {
        int n=s.length();
        String s2=new StringBuilder(s).reverse().toString();
        int l=tabu(s,s2);
        return n-l;
    }
    static int tabu(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int [][] dp= new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int i=0;i<=m;i++) dp[0][i]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}

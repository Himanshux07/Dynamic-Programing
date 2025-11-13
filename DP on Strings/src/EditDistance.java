//https://leetcode.com/problems/edit-distance/description/
import java.util.*;
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int [][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(word1,word2,n-1,m-1,dp);
    }
    int rec(String s1,String s2,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        int op1=0,op2=0,op3=0;
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=rec(s1,s2,i-1,j-1,dp);
        else{
            op1=1+rec(s1,s2,i-1,j-1,dp);
            op2=1+rec(s1,s2,i,j-1,dp);
            op3=1+rec(s1,s2,i-1,j,dp);
        }
        return dp[i][j]=Math.min(op1,Math.min(op3,op2));
    }
}

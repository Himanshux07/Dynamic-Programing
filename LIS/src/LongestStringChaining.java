//https://leetcode.com/problems/longest-string-chain/
import java.util.Arrays;

public class LongestStringChaining {
    boolean check(String s,String t){
        if(s.length()!=t.length()+1) return false;
        int i=0;
        int j=0;
        while(i<s.length()){
            if(j<t.length() && s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(i==s.length() && j==t.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a, b)->a.length()-b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int [] idx=new int[n];
        int maxi=0;
        int lastIndx=0;
        for (int i=0;i<n;i++){
            idx[i]=i;
            for (int j=0;j<i;j++){
                if(check(words[i],words[j]) && 1+dp[j]>dp[i]){
                    dp[i]=dp[j]+1;
                    idx[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
            }
        }
        return maxi;
    }
}

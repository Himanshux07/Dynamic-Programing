public class LCSubsrting {

    //recursion
    static int rec(String s1,String s2,int idx1,int idx2){
        if(idx1<0 || idx2<0) return 0;
        int r2=0;
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            r2=1+rec(s1,s2,idx1-1,idx2-1);
        }

        int r1=Math.max(rec(s1,s2,idx1-1,idx2),rec(s1,s2,idx1,idx2-1));
        return Math.max(r1,r2);
    }
    // tabulation
    static int tabu(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        //shifting of index 0--->-1,n----->n-1
        int max=0;
        int [][] dp= new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int i=0;i<=m;i++) dp[0][i]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                }
                else dp[i][j]=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(tabu("himansu","manshu"));
        System.out.println(rec("himansu","manshu",6,5));
    }
}

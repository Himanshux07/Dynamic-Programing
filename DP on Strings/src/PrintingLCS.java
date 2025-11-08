public class PrintingLCS {
    static String tabu(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        //shifting of index 0--->-1,n----->n-1
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

        StringBuilder ans= new StringBuilder();
        int i=n,j=m;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else j--;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(tabu("jklmn","acdlkmn"));
    }
}

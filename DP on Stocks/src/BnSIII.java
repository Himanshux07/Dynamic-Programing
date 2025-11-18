//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

public class BnSIII {
    // recursive
    static int rec(int [] arr,int idx,int tran){
        if(tran==4) return 0;
        if(idx==arr.length) return 0;
        int profit=0;
        if(tran%2==0){
            profit=Math.max(-(arr[idx])+rec(arr,idx+1,tran+1),rec(arr,idx+1,tran));
        }
        else{
            profit=Math.max((arr[idx])+rec(arr,idx+1,tran+1),rec(arr,idx+1,tran));
        }
        return profit;
    }

    //memoization
    static int tabu(int [] arr,int idx,int tran,Integer [][] dp){
        if(tran==4) return 0;
        if(idx==arr.length) return 0;
        if(dp[idx][tran]!=null ) return dp[idx][tran];
        int profit=0;
        if(tran%2==0){
            profit=Math.max(-(arr[idx])+tabu(arr,idx+1,tran+1,dp),tabu(arr,idx+1,tran,dp));
        }
        else{
            profit=Math.max((arr[idx])+tabu(arr,idx+1,tran+1,dp),tabu(arr,idx+1,tran,dp));
        }
        return profit;
    }

    // tabulation
    static int tabu(int [] arr){
        int n= arr.length;
        int [][] dp = new int[n+1][5];
        for(int i=0;i<=n;i++){
            dp[i][4]=0;
        }
        for(int i=0;i<5;i++){
            dp[n][i]=0;
        }
        for(int idx=n-1;idx>=0;idx--){
            for(int tran=0;tran<4;tran++){
                int profit=0;
                if(tran%2==0){
                    profit=Math.max(-(arr[idx])+dp[idx+1][tran+1],dp[idx+1][tran]);
                }
                else{
                    profit=Math.max((arr[idx])+dp[idx+1][tran+1],dp[idx+1][tran]);
                }
                dp[idx][tran]=profit;
            }
        }
        return dp[0][0];
    }

    // space opt
    static  int spcOpt(int [] arr){
        int n= arr.length;
        int [] ahead = new int[5];
        ahead[4]=0;
        for(int i=0;i<5;i++){
            ahead[i]=0;
        }
        for(int idx=n-1;idx>=0;idx--){
            int [] crr = new int[5];
            for(int tran=0;tran<4;tran++){
                int profit=0;
                if(tran%2==0){
                    profit=Math.max(-(arr[idx])+ahead[tran+1],ahead[tran]);
                }
                else{
                    profit=Math.max((arr[idx])+ahead[tran+1],ahead[tran]);
                }
                crr[tran]=profit;
            }
            ahead=crr;
        }
        return ahead[0];
    }
}

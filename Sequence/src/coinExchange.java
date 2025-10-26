// https://leetcode.com/problems/coin-change/

public class coinExchange{
    //recursive
    int rec(int [] arr,int target,int index){
        if(index==0) {
            if (target % arr[0] == 0) return target / arr[0];
            return (int) 1e9;
        }
        int notPick=rec(arr,target,index-1);
        int pick=(int) 1e9;
        if(target>=arr[index]) pick=1+rec(arr,target-arr[index],index);

        return Math.min(pick,notPick);
    }

    //tabulation
    int tabu(int [] arr,int target,int index,int [][] dp){
        if(index==0){
            if(target%arr[0]==0) return target/arr[0];
            return (int) 1e9;
        }
        if(dp[index][target]!=0) return dp[index][target];
        int notPick=tabu(arr,target,index-1,dp);
        int pick=(int) 1e9;
        if(target>=arr[index]) pick=1+tabu(arr,target-arr[index],index,dp);

        return dp[index][target]=Math.min(pick,notPick);
    }

    //memoization
    static int tabu(int [] arr,int target){
        int n=arr.length;
        int [][] dp= new int[n][target+1];

        for(int i=0;i<=target;i++){
            if(i%arr[0]==0) dp[0][i]=i/arr[0];
            else dp[0][i]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int notPick=dp[i-1][j];
                int pick=(int) 1e9;
                if(j>=arr[i]) pick=1+dp[i][j-arr[i]];

                dp[i][j]=Math.min(pick,notPick);
            }
        }
        return dp[n-1][target];
    }

    //space optimization
    static int spcOpt(int [] arr,int target){
        int n=arr.length;
        int [] prev= new int[target+1];

        for(int i=0;i<=target;i++){
            if(i%arr[0]==0) prev[i]=i/arr[0];
            else prev[i]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            int [] curr= new int[target+1];
            for(int j=0;j<=target;j++){
                int notPick=prev[j];
                int pick=(int) 1e9;
                if(j>=arr[i]) pick=1+curr[j-arr[i]];

                curr[j]=Math.min(pick,notPick);
            }
        }
        return prev[target];
    }
}

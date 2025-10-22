public class NoOfSubsetSumEqualstoTarget {

    //recursion
    static int rec(int [] arr,int target,int index){
        if(target==0) return 1;
        if(index<0 || target<0) return 0;
        int notPick=rec(arr,target,index-1);
        int pick=rec(arr,target-arr[index],index-1);

        return pick+notPick;
    }

    // memoization
    static int memo(int [] arr,int target,int index,int [][] dp){
        if(target==0) return 1;
        if(index<0 || target<0) return 0;
        if(dp[index][target]!=0) return dp[index][target];
        int notPick=rec(arr,target,index-1);
        int pick=rec(arr,target-arr[index],index-1);

        return dp[index][target]=pick+notPick;
    }

    //tabulation
    static int tabu(int [] arr,int target){
        int n=arr.length;
        int [][] dp= new int[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        if(target>=arr[0]) dp[0][arr[0]]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int notPick=dp[i-1][j];
                int pick=0;
                if(j>=arr[i]) pick=dp[i-1][j-arr[i]];

                dp[i][j]=pick+notPick;
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int [] arr={1,1,2,2,3,5};
        int [][] dp = new int[6][6];
        System.out.println(rec(arr,5,5));
        System.out.println(memo(arr,5,5,dp));
        System.out.println(tabu(arr,5));
    }
}

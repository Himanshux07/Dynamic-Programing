public class NoOfSubsetSumEqualstoTarget {

    //recursion
    static int rec(int [] arr,int target,int index){
        if(target==0) return 1;
        if(index<0 || target<0) return 0;
        int pick=rec(arr,target,index-1);
        int notPickup=rec(arr,target-arr[index],index-1);

        return pick+notPickup;
    }

    // memoization
    static int memo(int [] arr,int target,int index,int [][] dp){
        if(target==0) return 1;
        if(index<0 || target<0) return 0;
        if(dp[index][target]!=0) return dp[index][target];
        int pick=rec(arr,target,index-1);
        int notPickup=rec(arr,target-arr[index],index-1);

        return dp[index][target]=pick+notPickup;
    }

    public static void main(String[] args) {
        int [] arr={1,1,2,2,3,5};
        int [][] dp = new int[6][6];
        System.out.println(rec(arr,5,5));
        System.out.println(memo(arr,5,5,dp));
    }
}

//  Given N length of rod and array of size N 1 Based Index
//  cut the rod into pieces such that prices of each piece depend upon array
// Example N=5; arr=[3,4,5,7,9]
// 5 can be cut into piece of 4+1=== Price will be 7+3=10;

public class RodCutting {

    //recursive
    static int rec(int [] arr,int n,int index){
        if(index==0){
            return arr[0]*n;
        }
        int notPick=+rec(arr,n,index-1);
        int Pick=(int)-1e9;
        int idx=index+1;
        if(idx<=n) Pick=arr[index]+rec(arr,n-arr[index],index-1);

        return Math.max(notPick,Pick);
    }

    //memoization
    static int memo(int [] arr,int n,int index,int [][] dp){
        if(index==0){
            return arr[0]*n;
        }
        if(dp[index][n]!=-1) return dp[index][n];
        int notPick=+memo(arr,n,index-1,dp);
        int Pick=(int)-1e9;
        int idx=index+1;
        if(idx<=n) Pick=arr[index]+memo(arr,n-arr[index],index-1,dp);

        return dp[index][n]=Math.max(notPick,Pick);
    }

}

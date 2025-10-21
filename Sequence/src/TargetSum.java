// subsequence sum equals to target
public class TargetSum {

    // recursion
    static boolean rec(int [] arr,int target,int index){
        if(target==0) return true;
        if(index==0) return arr[0]==target;

        boolean notTake=rec(arr,target,index-1);
        boolean Take=false;
        if(arr[index]<=target)   Take=rec(arr,target-arr[index],index-1);

        return notTake || Take;
    }

    //memoization
    static boolean memo(int [] arr,int target,int index,boolean[][] dp){
        if(target==0) return true;
        if(index==0) return arr[0]==target;
        if(dp[index][target]) return true;
        boolean notTake=rec(arr,target,index-1);
        boolean Take=false;
        if(arr[index]<=target)   Take=rec(arr,target-arr[index],index-1);

        return dp[index][target]=notTake || Take;
    }

    public static void main(String[] args) {
        System.out.println(rec(new int[]{2,4,11,3,9,16},7,2));
        System.out.println();
    }
}

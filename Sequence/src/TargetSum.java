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

    // tabulation
    static boolean tabu(int [] arr,int target){
        boolean[][] dp = new boolean [arr.length][target];

        for(int i=0;i<arr.length;i++) dp[i][0]=true;
        dp[0][arr[0]]=true;

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=target;j++){
                boolean notTake=dp[i-1][j];
                boolean Take=false;
                if(arr[i]<=target)   Take=dp[i-1][j-arr[i]];

                dp[i][j]=notTake || Take;
            }
        }
        return dp[arr.length-1][target];
    }

    // Space Optimization
    static boolean spcOpt(int [] arr,int target){
        boolean[] prev=new boolean[target+1];
        prev[0]=true;
        prev[arr[0]]=true;

        for(int i=1;i<arr.length;i++){
            boolean[] curr= new boolean[target+1];
            curr[0]=true;
            for(int j=1;j<=target;j++){
                boolean notTake=prev[j];
                boolean Take=false;
                if(arr[i]<=j)   Take=prev[j-arr[i]];

                curr[j]=notTake || Take;
            }
            prev=curr;
        }
        return prev[target];
    }

    public static void main(String[] args) {
//        System.out.println(rec(new int[]{2,4,11,3,9,16},7,2));
//        boolean[][] dp = new boolean [7][12]; // target=12-1=11
//
//        System.out.println(memo(new int[]{2,4,11,3,9,16},11,3,dp));
    }
}

public class PartitionSumEqualSum {
    public boolean canPartition(int[] nums){
        int n=nums.length;
        int total = 0;
        for(int x:nums) total+=x;
        if(total%2!=0) return false;
        int target=total/2;
        Boolean[][] dp=new Boolean[n][target+1];
        return helper(nums,target,n-1,dp);
    }

    boolean helper(int[] arr,int target,int i,Boolean[][] dp){
        if(target==0) return true;
        if(i==0) return arr[0]==target;
        if(dp[i][target]!=null) return dp[i][target];

        boolean notTake=helper(arr,target,i-1,dp);
        boolean take=false;
        if(arr[i]<=target) take=helper(arr,target-arr[i],i-1,dp);

        return dp[i][target]=take||notTake;
    }
}

public class Leetcode2035 {
    int sum=0; public int minimumDifference(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return spcOpt(nums,sum);
    }
    int spcOpt(int [] arr,int target){
        boolean[] prev=new boolean[target+1];
        prev[0]=true;
        prev[arr[0]]=true;
        for(int i=1;i<arr.length;i++){
            boolean[] curr= new boolean[target+1];
            curr[0]=true;
            for(int j=1;j<=target;j++){
                boolean notTake=prev[j];
                boolean Take=false;
                if(arr[i]<=target)
                    Take=prev[target-arr[i]];
                curr[j]=notTake || Take;
            }
            prev=curr;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=target/2;i++){
            if(prev[target]){
                min=Math.min(min,Math.abs(sum-i));
            }
        }
        return min;
    }
}
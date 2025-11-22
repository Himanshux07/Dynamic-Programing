import java.util.Arrays;

public class Printing {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int [] idx=new int[n];
        int maxi=0;
        int lastIndx=0;
        for (int i=0;i<n;i++){
            idx[i]=i;
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j] && 1+dp[j]>dp[i]){
                    dp[i]=dp[j]+1;
                    idx[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndx=i;
            }
        }
        int [] ans=new int[maxi];
        int i=maxi-1;
        while(idx[lastIndx]!=lastIndx){
            lastIndx=idx[lastIndx];
            ans[i--]=nums[lastIndx];
        }
        System.out.println(Arrays.toString(ans));
        return maxi;
    }

    public static void main(String[] args) {
        int [] arr={5,4,11,1,16,18};
        System.out.println(lengthOfLIS(arr));
    }
}

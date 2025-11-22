//https://leetcode.com/problems/largest-divisible-subset/
import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int [] idx=new int[n];
        int maxi=0;
        int lastIndx=0;
        for (int i=0;i<n;i++){
            idx[i]=i;
            for (int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=dp[j]+1;
                    idx[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndx=i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndx]);
        while(idx[lastIndx]!=lastIndx){
            lastIndx=idx[lastIndx];
            list.addFirst(nums[lastIndx]);
        }
        return list;
    }
}

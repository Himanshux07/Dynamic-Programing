//https://leetcode.com/problems/house-robber-ii/
public class HouseRob2 {

    public int rob(int[] nums) {
        int n=nums.length;
        if(n<2) return nums[0];
        int prev=nums[1];
        int prev2=0;
        for(int i=2;i<n;i++){
            int pick=nums[i]+prev2;
            int notpick=prev;

            int curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        int ans1=prev;

        prev=nums[0];
        prev2=0;
        for(int i=1;i<n-1;i++){
            int pick=nums[i]+prev2;
            int notpick=prev;

            int curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        int ans2=prev;

        return Math.max(ans1,ans2);

    }
}

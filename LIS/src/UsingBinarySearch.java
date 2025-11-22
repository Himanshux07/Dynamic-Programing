import java.util.ArrayList;

public class UsingBinarySearch {
    public static int lengthOfLIS(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i]>ans.getLast()){
                ans.add(arr[i]);

            }
            else{
                int idx=upperBound(ans,arr[i]);
                ans.set(idx,arr[i]);
            }
        }
        return ans.size();
    }
    static int upperBound(ArrayList<Integer> list,int target){
        int low=0;
        int high=list.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(list.get(mid)==target) return mid;

            if(list.get(mid)>=target) high=mid-1;
            else low=mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int [] arr={5,4,11,1,16,18};
        System.out.println(lengthOfLIS(arr));
    }
}

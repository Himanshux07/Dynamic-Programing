public class MCM {
    //recursion way
    static int rec(int i,int j,int[] arr){
        if(i==j) return 0;
        int ans=(int)1e9;
        for(int k=i;k<=j-1;k++){
            int steps=arr[i-1]*arr[k]*arr[j]+rec(i,k,arr)+rec(k+1,j,arr);
            ans=Math.min(ans,steps);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rec(1,4,new int[]{10,20,30,40,50}));
    }
}

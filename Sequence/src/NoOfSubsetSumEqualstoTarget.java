public class NoOfSubsetSumEqualstoTarget {

    //recursion
    static int rec(int [] arr,int target,int index){
        if(target==0) return 1;
        if(index<0 || target<0) return 0;
        int pick=rec(arr,target,index-1);
        int notPickup=rec(arr,target-arr[index],index-1);

        return pick+notPickup;
    }

    public static void main(String[] args) {
        int [] arr={1,1,2,2,3,5};
        System.out.println(rec(arr,5,5));
    }
}

public class BnSIII {
    // recursive
    static int rec(int [] arr,int idx,int tran){
        if(tran==4) return 0;
        if(idx==arr.length) return 0;
        int profit=0;
        if(tran%2==0){
            profit=Math.max(-(arr[idx])+rec(arr,idx+1,tran+1),rec(arr,idx+1,tran));
        }
        else{
            profit=Math.max((arr[idx])+rec(arr,idx+1,tran+1),rec(arr,idx+1,tran));
        }
        return profit;
    }

}

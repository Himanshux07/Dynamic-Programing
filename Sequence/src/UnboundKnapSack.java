//infinite supply
public class UnboundKnapSack {

    //recursion
    static int rec(int[] wt,int[] prf,int idx,int maxWt){
        if(idx==0){
            return (maxWt/wt[0])*prf[0];
        }
        int notPick=rec(wt,prf,idx-1,maxWt);
        int pick=0;
        if(maxWt>=wt[idx]) pick=prf[idx]+rec(wt,prf,idx,maxWt-wt[idx]);

        return Math.max(notPick,pick);
    }

    public static void main(String[] args) {
        int[] wt={2,4,6};
        int[] prf={5,11,13};
        System.out.println(rec(wt,prf,2,10));
    }
}

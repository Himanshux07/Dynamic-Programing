//infinite supply
public class UnboundKnapSack {

    //recursion
    static int rec(int[] wt,int[] prf,int idx,int maxWt){
        if(idx==0){
            return (maxWt%wt[0])*prf[0];
        }
        int notPick=rec(wt,prf,idx-1,maxWt);
        int pick=0;
        if(maxWt>=wt[idx]) pick=wt[idx]+rec(wt,prf,idx,maxWt-wt[idx]);

        return Math.max(notPick,pick);
    }

}

public class KnapSack{

    //recursive
    static int rec(int [] wt,int [] val,int maxWt,int index){
        if(index==0){
            if(wt[0]<=maxWt) return val[0];
            else return 0;
        }
        int notPick=rec(wt,val,maxWt,index-1);
        int pick=(int)-1e9;
        if(wt[index]<=maxWt) pick=val[index]+rec(wt,val,maxWt-wt[index],index-1);

        return Math.max(pick,notPick);
    }

    public static void main(String[] args) {
        int [] wt={4,1,3,5,7};
        int [] val={6,11,4,7,13};
        int maxWt=11;
        System.out.println(rec(wt,val,maxWt,4));
    }
}

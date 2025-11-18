public class BnSIV {
    public int maxProfit(int k, int[] arr) {
        int n= arr.length;
        int [] ahead = new int[2*k+1];
        ahead[2*k]=0;
        for(int i=0;i<2*k+1;i++){
            ahead[i]=0;
        }
        for(int idx=n-1;idx>=0;idx--){
            int [] crr = new int[2*k+1];
            for(int tran=0;tran<2*k;tran++){
                int profit=0;
                if(tran%2==0){
                    profit=Math.max(-(arr[idx])+ahead[tran+1],ahead[tran]);
                }
                else{
                    profit=Math.max((arr[idx])+ahead[tran+1],ahead[tran]);
                }
                crr[tran]=profit;
            }
            ahead=crr;
        }
        return ahead[0];
    }
}

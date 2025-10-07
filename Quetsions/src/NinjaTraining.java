public class NinjaTraining {
    static int recursive(int [][] arr,int idx,int days){
        if(days==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=idx){
                    maxi=Math.max(maxi,arr[days][i]);
                }
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=idx){
                int points=arr[days][i]+recursive(arr,i,days-1);
                maxi=Math.max(maxi,points);
            }
        }
        return maxi;
    }

    //memoization
    static int memo(int [][] arr,int idx,int days,int [][]dp){
        if(days==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=idx){
                    maxi=Math.max(maxi,arr[days][i]);
                }
            }
            return maxi;
        }
        if (dp[days][idx]!=-1) return dp[days][idx];
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=idx){
                int points=arr[days][i]+recursive(arr,i,days-1);
                maxi=Math.max(maxi,points);
            }
        }
        return dp[days][idx]=maxi;
    }

    static int ninja(int [][] arr){
        return recursive(arr,arr.length-1,3);
    }

    public static void main(String[] args) {
        System.out.println(ninja(new int[][]{{2,1,3},{3,4,6},{10,1,6},{8,3,7}}));
    }
}

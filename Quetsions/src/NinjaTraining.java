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

    // Tabulation
    static int tabu(int [][] arr){
        int n=arr.length;
        int [][] dp=new int[n][4];

        dp[0][0]=Math.max(arr[0][1],arr[0][2]);
        dp[0][1]=Math.max(arr[0][0],arr[0][2]);
        dp[0][2]=Math.max(arr[0][0],arr[0][1]);
        dp[0][3]=Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));

        for(int days=1;days<n;days++){
            for(int last=0;last<4;last++){
                for(int idx=0;idx<3;idx++){
                    if(idx!=last){
                        int points=arr[days][idx]+dp[days-1][idx];
                        dp[days][last]=Math.max(dp[days][last],points);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    static int spcOpt(int [][] arr){
        int n=arr.length;
        int [] prev=new int[4];

        prev[0]=Math.max(arr[0][1],arr[0][2]);
        prev[1]=Math.max(arr[0][0],arr[0][2]);
        prev[2]=Math.max(arr[0][0],arr[0][1]);
        prev[3]=Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));

        for(int days=1;days<n;days++){
            int [] temp=new int[4];
            for(int last=0;last<4;last++){
                for(int idx=0;idx<3;idx++){
                    if(idx!=last){
                        int points=arr[days][idx]+prev[idx];
                        temp[last]=Math.max(temp[last],points);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }
    static int ninja(int [][] arr){
        return recursive(arr,arr.length-1,3);
    }

    public static void main(String[] args) {
        System.out.println(ninja(new int[][]{{2,1,3},{3,4,6},{10,1,6},{8,3,7}}));
        System.out.println(tabu(new int[][]{{2,1,3},{3,4,6},{10,1,6},{8,3,7}}));
        System.out.println(spcOpt(new int[][]{{2,1,3},{3,4,6},{10,1,6},{8,3,7}}));
    }
}

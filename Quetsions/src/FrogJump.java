public class FrogJump {
    // Recursive
    static int rec(int n,int [] arr){
        if (n==0) return 0;

        int left=rec(n-1,arr)+ Math.abs(arr[n]-arr[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1) right= rec(n-2,arr)+ Math.abs(arr[n]-arr[n-2]);

        return Math.min(left,right);
    }

    //Memoization (top-down); 0(N)-------------O(N)+O(N)
    static int memo(int n,int [] arr,int [] dp){
        if (n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left=memo(n-1,arr,dp)+ Math.abs(arr[n]-arr[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1) right= memo(n-2,arr,dp)+ Math.abs(arr[n]-arr[n-2]);

        return dp[n]=Math.min(left,right);
    }

    //Tabulation (bottom-up) O(N) ------------O(N)
    static int tabu(int n,int []arr){
        int [] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int left= dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1) right= dp[i-2]+Math.abs(arr[i]-arr[i-2]);

            dp[i]=Math.min(left,right);

        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(rec(3,new int[]{30,10,60,10,60,50}));
        System.out.println(memo(3,new int[]{30,10,60,10,60,50},new int[]{-1,-1,-1,-1}));
        System.out.println(tabu(3,new int[]{30,10,60,10,60,50}));
    }

}

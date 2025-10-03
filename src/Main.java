import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static int recFibo(int n,int []dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=recFibo(n-1,dp)+recFibo(n-2,dp);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(recFibo(n, dp));
    }
}
public class Climbingstairs {
    // recursive method
    public static int solution(int n) {
        if (n <= 2) return n;

        int first = solution(n - 1);
        int second = solution(n - 2);
        return first + second;
    }

    //memoization method

    public int climbStairs(int n) {
        if (n<=2) return n;

        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(7));
    }
}
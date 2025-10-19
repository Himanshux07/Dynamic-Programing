//https://leetcode.com/problems/cherry-pickup-ii/

public class CheeryPickUpII {
    int n;
    int m;
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        return helper(grid,0,0,m-1);
    }

    // recursive
    int helper(int [][] arr,int i,int j1,int j2){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)-1e9;
        }
        if(i==n-1){
            if(j1!=j2) return arr[i][j1]+arr[i][j2];
            return arr[i][j1];
        }
        int maxi=(int)-1e9;
        for(int c1=-1;c1<=1;c1++){
            for(int c2=-1;c2<=1;c2++){
                maxi=Math.max(helper(arr,i+1,j1+c1,j2+c2),maxi);
            }
        }
        if(j1==j2) maxi+=arr[i][j1];
        else maxi+=arr[i][j1]+arr[i][j2];
        return maxi;
    }


}

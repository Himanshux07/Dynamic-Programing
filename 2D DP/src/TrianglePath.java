public class TrianglePath {

    // Recursive
    static int rec(int [][] arr,int i,int j){
        if(i==arr.length-1) return arr[i][j];

        int down =arr[i][j]+rec(arr,i+1,j);
        int diagonal=arr[i][j]+rec(arr,i+1,j+1);

        return Math.min(down, diagonal);
    }


}

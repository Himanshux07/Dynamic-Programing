public class UniquePath {
    //recursive
    static int recur(int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0) return 0;

        int left=recur(i,j-1);
        int right=recur(i-1,j);

        return left+right;
    }


}

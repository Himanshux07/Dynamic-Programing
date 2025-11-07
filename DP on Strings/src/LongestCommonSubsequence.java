public class LongestCommonSubsequence {

    //recursive
    static int rec(String s,int idx1,int idx2){
        if(idx1<0 || idx2<0) return 0;
        if(s.charAt(idx1)==s.charAt(idx2)){
            return 1+rec(s,idx1-1,idx2-1);
        }
        else return Math.max(rec(s,idx1-1,idx2),rec(s,idx1,idx2-1));
    }

}

public class LongestCommonSubsequence {

    //recursive
    static int rec(String s1,String s2,int idx1,int idx2){
        if(idx1<0 || idx2<0) return 0;
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return 1+rec(s1,s2,idx1-1,idx2-1);
        }
        else return Math.max(rec(s1,s2,idx1-1,idx2),rec(s1,s2,idx1,idx2-1));
    }

    public static void main(String[] args) {
        System.out.println(rec("himanshu","palak",7,4));
    }
}

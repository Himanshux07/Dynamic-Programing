
public class coinExchange{
    //recursive
    int rec(int [] arr,int target,int index){
        if(index==0) {
            if (target % arr[0] == 0) return target / arr[0];
            return (int) 1e9;
        }
        int notPick=rec(arr,target,index-1);
        int pick=(int) 1e9;
        if(target>=arr[index]) pick=1+rec(arr,target-arr[index],index);

        return Math.min(pick,notPick);
    }
}

package array;

public class Consecutive {
  public static int consecutive(int[]arr){
    int max =0;
    for(int i=0;i<arr.length;i++){
        int target =arr[i];
        int count=0;
        while(linearsearch(arr, target)){
            count++;
            target++;
        }
        max=Math.max(max,count);
    }
    return max;

}
public static boolean linearsearch(int[]arr,int target){
    for(int i=0;i<arr.length;i++){
        if(target==arr[i]){
            return true;
        }
    }
    return false;
}
}

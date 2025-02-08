package array;

public class MoveZeroEnd {
  public static int[] moveZeroEnd(int[]num){
    int[] arr = MakeCopy.makeCopy(num);
    int j=0;
    for(int i=0;i<arr.length;i++){
      if(arr[i]==0){
        continue;
      }
      else{
        arr[j]=arr[i];
        j++;
      }
    }
    for(;j<arr.length;j++){
      arr[j]=0;
    }
    return arr;
  }
}

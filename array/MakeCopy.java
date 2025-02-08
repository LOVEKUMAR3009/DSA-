package array;

public class MakeCopy {
public static int[] makeCopy(int []num){
  int [] arr=new int[num.length] ;
    for (int i=0;i<num.length;i++) {
      arr[i] = num[i];
    }
    return arr;
}
}

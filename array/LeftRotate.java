package array;
import java.util.*;
public class LeftRotate {

  public static void leftRotate(int[]num,int k){
    //brute force
    int [] arry=MakeCopy.makeCopy(num);
    k= k%arry.length;
    for (int j = 0; j < k; j++) {
      int key = 0;
      for (int i = 1; i < arry.length; i++) {
          swap(arry, key, i);
          key++;
      }
    }

    System.out.println(Arrays.toString(arry));
  }

  public static void swap(int[] arry, int key, int i) {
    int temp = arry[key];
    arry[key] = arry[i];
    arry[i] = temp ;
  }

  public static void leftRotateOne(int[]arr){
    int temp = arr[0];
    for(int i=1;i<arr.length;i++){
      arr[i-1] = arr[i];
    }
    arr[arr.length-1]=temp;
    System.out.println(Arrays.toString(arr));

  }
  public static void leftRotateDplace(int[]arr,int d){
    d=d%(arr.length);
    int []temp = new int[d];
    for(int j=0;j<d;j++){
      temp[j]=arr[j];
    }
    int i=d;
    for(;i<arr.length;i++){
      arr[i-d] = arr[i];
    }
    for(int j=0;j<temp.length;j++){
      arr[i-d]=temp[j];
      i++;
    }
    System.out.println(Arrays.toString(arr));
  }

  public static void reverseArray(int[]arr,int first,int last){
    while(first<last){
      swap(arr, last, first);
      first++;
      last--;
    }
    // System.out.println(Arrays.toString(arr));
  }
  public static void  leftRotateDplaceOptimal(int[]arr,int d){
    reverseArray(arr, 0, d-1);
    reverseArray(arr, d, arr.length-1);
    reverseArray(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
  }
}


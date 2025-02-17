package sorting.selction;

public class Swapping {
  public static void swap(int[] arr,int firstIndex,int lastIndex){
    int temp = arr[firstIndex];
    arr[firstIndex] = arr[lastIndex] ;
    arr[lastIndex] = temp ;
  }
}

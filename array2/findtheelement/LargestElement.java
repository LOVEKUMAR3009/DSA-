package array2.findtheelement;

import java.util.Arrays;

public class LargestElement {
  public static void main(String[] args) {
    //testing the algo
    int[] arr = {1, 4,3,2,5};
    findLargestOptimal(arr);
    int largestElement = findLargest(arr);
    System.out.println(largestElement);
    System.out.println(Arrays.toString(arr));
  }
  //brute force (o(nlogn))
  public static int findLargest(int[] array) {
    //sort the array
    Arrays.sort(array);
  return array[array.length-1];
  }



  //optimal solution (o(n))
  public static int findLargestOptimal(int[] array) {
    int max = array[0];
    for(int i =0;i<array.length;i++){
      if(array[i]>max){
        max = array[i];
      }
    }
    return max;
}

}
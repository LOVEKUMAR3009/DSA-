package sorting.insertion;

import java.util.Arrays;

import sorting.selction.Swapping;

public class Insertion {
  public static void main(String[] args) {
    //testing

    int [] arr  = {4,3,5,7,9,8};
    int [] ans = insertionSort(arr);
    System.out.println(Arrays.toString(ans));
  }

  public static int[] insertionSort(int[] array) {
    int n = array.length;
    //every eleent will be picked
    for(int i =0;i<n;i++){
      int j= i;
      //while the element is smaller than the previous element
      while(j>0 && array[j]<array[j-1]){
        Swapping.swap(array, j-1, j);
        j--;
      }
      
    }
    return array;
  }
}

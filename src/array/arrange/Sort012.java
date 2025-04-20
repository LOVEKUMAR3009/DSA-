package array.arrange;

import java.util.Arrays;

import sorting.selction.Swapping;

public class Sort012 {
  public static void main(String[] args) {
    int [] arr = {1,2,1,0,0,0,1,2,2};
    sort012Optimal(arr);
    System.out.println(Arrays.toString(arr));
  }


  /*
   * brute solution is to use any sorting algo
   */

   /*
    * use the 3 variabel and count the occurence and than sort them

    time complexity is o(2n) and space complexity will be 
    o(1)
    */

    public static void sort123(int[] arr) {
      int n = arr.length;
      int count0 = 0, count1 = 0, count2 = 0;
      for (int i = 0; i < arr.length; i++) {
        if(arr[i]==0){
          count0++;
        }
        else if(arr[i]==1){
          count1++;
        }
        else{
          count2++;
        }
      }
      int i =0;
      // replacing the original array with 0 1 2 according to their count
      while(i<n){
        if(count0>0){
          arr[i]=0;
          count0--;
        }
        else if(count1>0){
          arr[i]=1;
          count1--;
        }
        else if(count2>0){
          arr[i]=2;
          count2--;
        }
        i++;
      }
  }


  
/*
 * 
 * optimal solution 
 * 
 * Dutch national flag algorithm 
 * 
 * rules 
 * 
 * these is hypothetical array
 * 1. every thing between [0,low) should be 0
 * 2. every thing between [low,mid) should be 1
 * 
 * 3. every thing between [mid,high] can be anything 0,1,2
 * 4. every thing between [high+1,n) should be 2
 * 
 * intuition is 
 * 
 * so in starting  the whole array is unsorted
 * 
 */
  public static void sort012Optimal(int[] arr) {
    int n = arr.length;
    int low = 0, mid = 0, high = n-1;
  
    while(mid<= high){
      // if mid element is 0 swap it with low element and move both
      if(arr[mid]==0){
        Swapping.swap(arr, low, mid);
        low++;
        mid++;
      }
      // if mid element is 1 move increase mid
      else if(arr[mid]==1){
        mid++;
      }
      // if mid is 2 swap it with high and decrease high
      else{
        Swapping.swap(arr, mid, high);
        high--;
  
      }
    }
  }
}





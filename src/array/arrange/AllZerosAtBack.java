package array.arrange;

import java.util.Arrays;

import sorting.selction.Swapping;



/*
 * time complexity is o(n)+o(n-x)+o(x) = o(2n)
 * spce complexity is o(n)
 */
public class AllZerosAtBack {
  public static void main(String[] args) {
    int[] arr = {0,1, 0, 0, 3, 12,1,0,1};
    //  int [] result = zeroAtLast(arr);
    // System.out.println(Arrays.toString(result));
    // zeroAtLast(arr);
    zerosAtBackOptimal(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void zeroAtLast(int[] arr) {
    int n = arr.length;
    int[] ans = new int[n];
    int pointer = 0;
    for(int i = 0;i<n;i++){
      //checking if the element is non-zero or not
      if(arr[i] != 0){
        ans[pointer]= arr[i];
        pointer++;
      }
    }
    
    //fill the non zero in the original array
   
    for(int i =0;i<ans.length;i++){
      arr[i] = ans[i];
    }
    for(int i =ans.length;i<n;i++){
      arr[i]=0;
    }
    // return ans;
}

/*
 * 
 */

 public static void zerosAtBackOptimal(int[]arr){
  int n = arr.length;
  int nonZeroIndex = 0;
  int i =0;
  //iterating over the array 
  while(i<n){
    // if the value is not zero than place that value at the nonZeroIndex
    if(arr[i] !=0){
      Swapping.swap(arr, nonZeroIndex, i);
      nonZeroIndex++;    
    }
    // if the value is zero than just increment the index
    i++;
  }
 
 }
}

package array2.findtheelement;

import sorting.merge.MergeSort;

public class SecondLargestElement {
  public static void main(String[] args) {
    int [] arr = {34,34,34,34,34,34};
    System.out.println(secondLargestElementOptimal(arr));
  }
  //brute force

  // o(nlogn+n)
  public static int secondLargestElement(int []array){
    // sort the array and find the secondlargest from end

    MergeSort.mergeSort(array,0,array.length-1);
    
    int largestElement = array[array.length-1];
    int n = array.length-1;
    int pointer = n-1;
    //checking if there is any repetiition of largest number
    while(pointer>=0 && array[pointer]==largestElement){
      pointer--;
    }
    if(pointer<0){
      return Integer.MIN_VALUE;
    }
    return array[pointer];
  }

  //better solution can be what if do 2 pass and find the largest and then second largest 
  public static int secondLargestElementBetter(int []array){
    //find the largest element in o(n)
    int largest = LargestElement.findLargestOptimal(array);
    int secondlargest = Integer.MIN_VALUE;
    //find the second largest element in o(n)
    for(int i =0;i<array.length;i++){
      if(array[i]> secondlargest && array[i]!=largest){
        secondlargest = array[i];
      }
    }
    return secondlargest;
}

/*
 * optimal solution intution is which element is largest till the moment for starting the first element is the largest because we have not seen any other element yet
 * and second largest is Integer.Minvalue because we have not seen any other element yet
 * 
 *
 *accordding to assunption my  next value in the array will be placed in the these three section only ---------------secondlargest-----------------largest--------
 * time complexity = o(n)
 */

  public static int secondLargestElementOptimal(int []array){
    int largest = array[0];
    int secondLargest = Integer.MIN_VALUE;
    for(int i=1;i<array.length;i++){
      if(array[i]>largest){
        secondLargest = largest;
        largest = array[i];
      }
      else if(array[i]>secondLargest && array[i]!=largest){
        secondLargest = array[i];
      }
      
    }
    return secondLargest;
  }
}
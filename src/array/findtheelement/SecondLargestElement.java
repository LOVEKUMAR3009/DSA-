package array.findtheelement;

import sorting.merge.MergeSort;

public class SecondLargestElement {
  public static void main(String[] args) {
    int [] arr = {34,34,34,34,34,34};

    int[] nums = {228 ,394 ,463 ,227 ,388 ,757 ,782 ,238 ,967};
    System.out.println(pairWithMaxSum(nums)-967);
    // System.out.println(secondLargestElementOptimal(arr));
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


  public static int pairWithMaxSum(int[] array) {
    // Your code goes here
    int sum =0;
    int secondlargest = Integer.MIN_VALUE;
    int largest = array[0];
    
    largest = Math.max(array[0],array[1]);
    secondlargest = Math.min(array[0],array[1]);
    
    for(int j =2;j<array.length;j++){
        if(array[j] > largest){
          secondlargest = largest;
            largest = array[j];
        }
        else if(array[j]> secondlargest && array[j]< largest){
            secondlargest  = array[j];
        }
        else{
            continue;
        }
        
    }
    return largest+secondlargest;

    
}
}
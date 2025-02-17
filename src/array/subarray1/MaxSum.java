package array.subarray1;

public class MaxSum {
  

  public static void main(String[] args) {
    int [] arr = {-2,-3,4,-1,-2,1,5,-3};
    int result = maxSubarraySumKadane(arr);
    System.out.println(result);
  }

  /*
   * brute force
   */
  public static int maxSubarraySum(int[] arr) {
    int n = arr.length;
    int maxSum = Integer.MIN_VALUE;

    for(int i =0;i<n;i++){
      int sum =0;
      for(int j = i;j<n;j++){
        sum += arr[j];
        maxSum = Math.max(maxSum, sum);
      }

    }
    return maxSum;
}



/*
 * kdane algorithm
   if we carray negative sum it will reduce the 
 */

 public static int maxSubarraySumKadane(int[] arr){
  int n = arr.length;
  int maxSum = Integer.MIN_VALUE;
  int first =-1;int last =-1;
  int sum = 0;
  int start=-1;
  for(int i =0;i<n;i++){
    //keeping the pointer wehre we can get the max sum
    if(sum ==0) start = i;

    sum +=arr[i];
    if(sum> maxSum){
      maxSum = sum;
      first = start;
      last = i;
    }
    if(sum < 0) 
    {
      sum = 0;
    }

  }
  System.out.println(first+" "+last);
  return maxSum;
 }
}

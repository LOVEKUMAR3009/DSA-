package array.findtheelement;

// import array.LinearSearch;
import searching.linear.*;

public class MissingNumber {
  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5};
    // int result = findTheElement(arr);
    // int result = findTheElementBetterApproach(arr)
    // int result = findTheElementOptimal(arr);
    int result = findTheElementXor(arr);
    System.out.println(result);
    
  }


  /*
   * brute force 
   * linear serch for every element in the array
   * 
   * time complexity o(n*n)
   * the array is N is the maximum number in the array and one number is missing 
   */
  public static int findTheElement(int[] arr) {
    int  n = arr.length;
    for(int i=1;i<=n;i++){
      //check if it is present or not
      int result = LinearSearch.linearSearch(arr,i);
      if(result == -1){
        return i;
      }
    }
    return -1;
  }

  /*
   * 
   * better approach is using hash first declare the 
   * 
   * space is o(n)
   * time complexity is o(2n)
   */

   public static int findTheElementBetterApproach(int[] arr) {
    // length of the arr
    int n = arr.length;
    // creating a hash arr because one number is missing and one position is for zero 
    boolean[] hash = new boolean[n+2];
    for(int i=0;i<n;i++){
      //check if it is present or not
      hash[arr[i]] = true;
    }

    // checking in the hash array form 1 to n which element is false
    for(int i=1;i<hash.length;i++){
      if(hash[i] == false){
        return i;
      }
    }
    return -1;
  }

  /*
   * using the naturalSum function
   */
  public static int findTheElementOptimal(int []arr){
    //sum of natural number from 1 to n where n is 1 more than  the length of the array
    int naturalSum = ((arr.length+1)*(arr.length+2))/2;
    for(int i=0;i<arr.length;i++){
      naturalSum = naturalSum - arr[i];
    }
    return naturalSum;

  }


  /*
   * xor operation can be used to   
   * 
   * a^a =0
   * 0^a = a
   * 
   * since we have one missing number in the continuous array so we can use the xor with the number from 1 to n
   * 
   * 
   * xor1 = 1^2^3^4^5^6^....^n
   * xor1 = 1^2^3^4^5^6^....^(n-1)
   * 
   * the computer will store xor1 and xor2 and if we do (xor1^xor2) it is as good as doing  1^2^3^4^5^6^....^n-1^1^2^3^4^5^6....^n and since we are doing this a^a=0 and a^0 =a is applicable and the one who is only once will be in the last 
   */

   public static int findTheElementXor(int []arr){
    int n = arr.length;
    int xor1 =0;
    int xor2 =0;

    // xor1 = 1^2^3^4^5^6^....^n
    for(int i=1;i<=n+1;i++){
      xor1 = xor1^i;
      
    }
    // xor2 = xor2^n;
    // xor2 = 1^2^3^4^5^6^....^n-1 
    for(int i =0;i<n;i++){
      xor2 = xor2^arr[i];
    }
    return xor1^xor2;
}

/*
 * space will not exceed because in sum we might exceed the size of the limit of the integer in java
 */

   public static int findTheElementXor2(int []arr){
    int n = arr.length;
    int xor1 =0;
    int xor2 =0;

    
    for(int i=1;i<=n;i++){
      // xor1 = 1^2^3^4^5^6^....^n
      xor1 = xor1^i;
      // xor1 = 1^2^3^4^5^6^....^n but one is missing 
      xor2 = xor2^arr[i-1];   
    }
    // last number is missing so xor1^xor2 will give the missing number
    xor1 = xor1^(n+1);
    return xor1^xor2;
}


}

package array.subarray1;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubarraySumK{
  public static void main(String[] args) {
    int[] arr = {1,2,-3,3,1,1,1,4,2,-3};
    
    System.out.println(noOfSubarraySumKOptimal(arr,1));
  }



  /*bruteforce is usign three loop first identify the subarray than count sun which tc will be near about n3*/


  /*  better solution is do counting of sum as the j increase and check if it is equal to k or not tc will be near about o(n2)*/
  public static int noOfSubarraySumK(int[] arr,int k){

    int count =0; 
    for(int i =0;i< arr.length;i++){
      int sum =0;
      for(int j =i;j<arr.length;j++){
        sum +=arr[j];
        if(sum == k){
          /*  use for testing purpose
          for(int p = i;p<=j;p++){
            // System.out.println(j);
            
            System.out.print(arr[p]);
          }
          System.out.print("    "+i+" "+j);
          System.out.println();
          */
          count++;
        }
      }

    }
    return count;
  }



  /*
   * optimal solution  
   * intution is how many times the s-k apperas in the array
   */

  public static int noOfSubarraySumKOptimal(int[] arr,int k){
    int n = arr.length;
    int count =0;
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    map.put(0,1);
    int sum =0;
    for(int i =0;i<n;i++){
      sum += arr[i];

      int complement = sum -k;

      // checking if there is possiblity of subarray with sum k and if yes how many are those
      if(map.containsKey(complement)){
        count += map.get(complement);
        // map.put(sum-k,map.get(sum-k)+1);
      }
      // checking how many points are there 
      if(map.containsKey(sum)){
        map.put(sum,map.get(sum)+1);
      }
      else{
        map.put(sum,1);
      }
      
    }

    
    return count;
  }
}

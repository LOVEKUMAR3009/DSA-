package array.subarray1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumK {
  public static void main(String[] args) {
    int[] arr = {-1,-2,-3,4,5,2,1};
    int k = 4;
    int result = longestSubarraySumK(arr,k);
    System.out.println(result);
  }


  /*
   * Brute force solution will be to generate all possible subarrays and check if their sum is equal to k
   */

  /*
   * this solution is optimal for negative numbers and postive numbers
   */
   public  static int longestSubarraySumK(int[] arr, int k) {
      Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is equal to k, update max length
            if (sum == k) {
                max = i + 1;
                
            }

            // If (sum - k) exists in map, we found a subarray with sum k
            if (map.containsKey(sum - k)) {
                int index = map.get(sum - k);
                max = Math.max(max, i - index);
            }

            // Store the first occurrence of sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;

    }



    /*
     * only for positve part not even zero contaning
     */
    public  static int longestSubarraySumPositiveK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is equal to k, update max length
            if (sum == k) {
                max = i + 1;
                return max;

            }

            // If (sum - k) exists in map, we found a subarray with sum k
            if (map.containsKey(sum - k)) {
                int index = map.get(sum - k);
                max = Math.max(max, i - index);
            }

            // Store the first occurrence of sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;

    }
}

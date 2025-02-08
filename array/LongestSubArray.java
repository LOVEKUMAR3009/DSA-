package array;
import java.util.*;
public class LongestSubArray {
  /*contiguous part of an array having sum equal to given sum */
  //own 
  public static int[] longestSubArray(int[]arr,int k){
    // List<Integer> temp = new ArrayList();
    int[]temp = new int[2];
    int count =0;
    for(int i=0;i<arr.length;i++){
        int j =i;
        int sum =0;
        
        while(sum<k && j<arr.length){
          sum+=arr[j];
          if(sum==k){
            if(count==0||count<(j-i)){
              temp[0]=i;
              temp[1]=j;
              count =j-i;
            }
            break;
          }
          j++;
        }
    }
    
    return temp;
  }
  //better soulution
  public static int lenOfLongestSubarr(int[]a,int k){
    /*
     * step 1 create a map
     * 2 we will store the sum and and index till that index in a map
     * 3. we will check the the remaing fo
     */
    Map<Integer,Integer> temp = new LinkedHashMap<>();
    int sum =0;
    int maxLen =0;
    for(int i=0;i<a.length;i++){
      // if(a[i]==0){
      //   continue;
      // }
      sum+=a[i];
      if(sum ==k){
        maxLen = Math.max(maxLen, i+1);
      }
      //
      int rem =sum-k;
      if(temp.isEmpty()){
        temp.put(sum, i);
      }
      
      if(temp.containsKey(rem)){
       maxLen = Math.max(maxLen, i-temp.get(rem));
       
      }
      if(!temp.containsKey(sum)){
        temp.put(sum,i);
      }
      // else{
      //   temp.put(sum, i);
      // }
    
    }
    // System.out.println(temp);
    return maxLen;
  }



  public static int longestSubarrayWithSumK(int []a, long k) {
    // Write your code here
   
    int left=0;
    int right=0;
    long sum=a[0];
    int max =0;
    int n = a.length;
    // int count=0;
    while(right<n){
      while(left<=right && sum>k){
        sum -= a[left];
        left++;
      }
      if(sum==k){
        max = Math.max(max,right-left+1);
      }
      right++;
      if(right<n){
        sum+=a[right];
      }
    }
    return max;
}
}

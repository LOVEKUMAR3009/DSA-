package array.findtheelement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
  public static void main(String[] args) {
    int [] nums = {2,2,2,2,1,1,1,1,3,3,3,3,3,3,3,3,3};
    int result = majorityElementOptimal(nums);
    System.out.println(result);
  }

  /*
   * tc = o(nlogn) +o(n)
   * sc = o(n)
   */
  // brute force solution
  public static int majorityElement(int[] nums) {
    // use map to store count of the element
    Map<Integer,Integer> map = new HashMap<>();
    for(int i =0;i<nums.length;i++){
      // if contains then increment and put that number again
      if(map.containsKey(nums[i])){
        map.put(nums[i],map.get(nums[i])+1);
      }
      // put the number in map and count is 1
      else{
        map.put(nums[i],1);
      }
    }
    // whoever count will be more than n/2 that will be the answer
    for (Integer key : map.keySet()) {
      if(map.get(key)> nums.length/2){
        return key;
      }
     
  }
  return Integer.MIN_VALUE;
  
}



/*
 * optimal solution is using moores voting algorithm
 * intution of the algo
 * 
 * every time 
 * we will check the majority in the chunks
 * 
 */
  
 public static int majorityElementOptimal(int[] nums) {
  int n = nums.length;
  int count = 0;
  int candidate =Integer.MIN_VALUE;
  for(int i =0;i<n;i++){
    // if count is 0 then we will choose the new candidate
    if(count==0){
      candidate = nums[i];
      count++;
    }
    // if the element is equal to candidate than we increase count 
    else if(nums[i] ==candidate){
      count++;
    }
    // if not than decrease the count 
    else{
      count--;
    }
    /*
     *  by doing this we are ensuring that this candidate key is not majority in this chunk if someone remainging in the last then either that element will be in majority or there will be no majority
     */
  }

  /*
   * if the problem has probable solution not sure solution
   */
  int ans = 0;
  for(int i =0;i<n;i++){
    if(nums[i] == candidate){
      ans++;
    }
      
  }
  if(ans> n/2){
    return candidate;
  }
  else {
    return Integer.MIN_VALUE;
  }


}
}

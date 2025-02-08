package array;

// import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {

  /*
   * brute force approch
   * two pointer for every combination
   */
    int[] arr =new int[2];
    for(int i=0;i<nums.length;i++){
      for(int j=i+1;j<nums.length;j++){
        int sum= nums[j]+nums[i];
        if(sum==target){
          arr[0]=i;
          arr[1]=j;
          return arr;
        }
      }
    }
    return arr;
  }

  public static int[] twoSum2(int[]nums,int target){
    int[] arr = new int[2];
    Map <Integer,Integer> ans = new HashMap<Integer,Integer>();
    for(int i=0;i<nums.length;i++){
      if(ans.isEmpty() || !ans.containsKey(target-nums[i])){
        ans.put(nums[i],i);
      }
      else{
        arr[0]=ans.get(target-nums[i]);
        arr[1]=i;

      }
    }
    return arr;
    
  }
}

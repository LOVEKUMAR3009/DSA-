package array;

public class Issorted {
  public static boolean isSorted(int[]arr){
    for (int i = 0; i < arr.length-1; i++) {
      if(arr[i]>arr[i+1]){
        return false;
      }
    }
    return true;
  }
  //leet code solution
  public boolean check(int[] nums) {
    //to check for rotated array
    if(nums[0]>=nums[nums.length-1]){
        int count =0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1]){
                count++;
            }
        }
        if(count<=1){
            return true;
        }
        else{
            return false;
        }
    }
    else{
        for (int i = 0; i < nums.length-1; i++) {
        if(nums[i]>nums[i+1]){
            return false;
        }
    }
    }
    return true;
}
}

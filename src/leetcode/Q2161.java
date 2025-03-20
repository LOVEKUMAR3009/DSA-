package leetcode;

import java.util.Arrays;

public class Q2161 {

    public static void main(String[] args) {
      int[] nums = {9,12,5,10,14,3,10};
      int[] ans = pivotArray(nums,10);
      System.out.println(Arrays.toString(ans));
    }
  
    public static int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;
        int start = 0;
        int end = n-1;

        
        while(start<=end ){
            if(nums[start] < pivot){
                start++;
                
            }
            if(nums[end] > pivot){
                end--;
                
            }
            if(nums[start] == pivot && nums[end] == pivot){
              start++;
            }
            if(start<end){

            swap(nums,start,end);
            }
                
            
        }
        return nums;
    }

     public static void swap(int[] arr,int firstIndex,int lastIndex){
                int temp = arr[firstIndex];
                arr[firstIndex] = arr[lastIndex] ;
                arr[lastIndex] = temp ;
    }


    public static int[] pivote(int[]arr,int pivot){
      int[] ans = new int[arr.length];
      int small = 0;
      int j =0;
      int large = arr.length-1;
      int pivoteIndex = 0;
      for(int i =0;i<arr.length;i++){
        if(arr[i] < pivot){
          ans[j] = arr[i];
          j++;
        }
      }
      return ans;
    }

}


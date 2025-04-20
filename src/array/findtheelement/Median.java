package array.findtheelement;

import java.util.Arrays;

public class Median {
  public static void main(String[] args) {
    int[] arr = {1,2};
    int []num = {3,4};
    double result = findMedianSortedArrays(arr,num);
    System.out.println(result);
  }
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] ans = merge(nums1,nums2);
    System.out.println(Arrays.toString(ans));
    if(ans.length%2!=0){
        int mid = ans.length/2;
        return(ans[mid]);
    }else{
        int mid =ans.length/2;
        int secondmid = mid-1;
        System.out.println(ans[mid]);
        System.out.println(ans[secondmid]);
        double result = ((double)ans[mid]+(double)ans[secondmid])/2;
        return result;
    }


}
public static int[] merge(int[]arr,int[]arr2){
int n = arr.length;
int m = arr2.length;
int [] nums = new int[n+m];
int temp=0;
//
int leftIndex =0;
int rightIndex =0;
while(leftIndex<n && rightIndex<m ){
  if(arr[leftIndex]<=arr2[rightIndex]){
    nums[temp]= arr[leftIndex];
    leftIndex++;
    temp++;
  }
  else{
    nums[temp] = arr2[rightIndex];
    rightIndex++;
    temp++;

  }
}
//remaining left side array is added to the temp
while(leftIndex<n){
  nums[temp]=arr[leftIndex];
  leftIndex++;
  temp++;
}
//remaining right side array is added to the temp
while(rightIndex<m){
    nums[temp] = arr2[rightIndex];
    rightIndex++;
    temp++;
}
return nums;
//adding sorted value in the original array
// return arr;
}
}

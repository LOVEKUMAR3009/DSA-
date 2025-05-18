package array.check;

public class Duplicate {
    public static void main(String[] args) {
        int[] arr = {9,9};
        System.out.println(containsNearbyDuplicate(arr, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int n = nums.length;
        int start = 0;
        int end = Math.min(k,n);
        while(end<n){
            if(ischeck(nums,start,end))return true;
            end++;
            start++;
        }
        return false;

    }

    public static boolean ischeck(int[]nums,int start,int end){
         for(int i = start;i<end;i++){
            for(int j = i+1;i<=end;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

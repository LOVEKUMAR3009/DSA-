package binarysearch.problems;

public class Bouqet {
  public static void main(String[] args) {
    int[] bloomDay = {7,7,7,7,12,7,7};
    int m = 2;
    int  k = 3;
    System.out.println(minDays(bloomDay, m, k));
    // System.out.println(countbouquet(bloomDay, m, k));
  }
    public static int minDays(int[] bloomDay, int m, int k) {
      int[] range = findLargestOptimal(bloomDay);
      int start = range[0];
      int end = range[1];
        int ans  = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int bouqetcount = countbouquet(bloomDay,mid,k);
            // System.out.println(bouqetcount);
            if(bouqetcount>=m){
              ans = mid;
              end = mid-1;
            }else{
              start = mid+1;
            }

        }
        return ans;
    }
    public static int countbouquet(int[]arr,int day,int k){
        int i = 0;
        int count = 0;
        while(i<=arr.length-k){
            int j = i;
            int m = 0;
            while(j<i+k){
                if(arr[j]<=day){
                    m++;
                    j++;
                }else{
                    j++;
                    break;
                }
            }
            if(m == k){
                count++;    
            }
            i = j;


        }
        return count;
    }
     public static int[] findLargestOptimal(int[] array) {
    int max = array[0];
    int min = array[0];
    int[] ans = new int[2];
    for(int i =0;i<array.length;i++){
      if(array[i]>max){
        max = array[i];
      }
      if(array[i]<min){
        min = array[i];
      }
    }
    ans[0] = min;
    ans[1] = max;
    return ans;
}
}


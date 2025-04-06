package binarysearch.problems;

public class MaxGasStation {
  public static void main(String[] args) {
    int[]arr = {1,2,3,4,5};
    System.out.println(MinimiseMaxDistance(arr, 4));
  }

    public static double MinimiseMaxDistance(int []arr, int k){
        // Write your code here.
        double start = 0;
        double end = range(arr);
        double ans = 0;
        // System.out.println(end);
        while(start<end){
            double mid  = start+(end-start)/2;
            
            int countofpossiblegas = countofpossiblegas(arr,mid,k);
            if(countofpossiblegas >k){
              start = mid+1;
            }else{
              ans = mid;
              end = mid-1;
            }
        }
        return ans;
    }

    public static int countofpossiblegas(int[]arr,double dist,int k){
      int count = 0;
      for(int i = 0;i<arr.length-1;i++){
        int temp = (int)((arr[i+1]-arr[i]-dist)/dist);
        count +=temp;
      }
      return count;
    }

    public static int range(int[]arr){
        int min = arr[arr.length-1]-arr[0];
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]<min){
                min = arr[i+1]-arr[i];
            }
        }
        return min;
    }
}


package binarysearch.problems;

public class ShipPackage {
    public static void main(String[] args) {
      int[] packages = {1,2,3,4,5,6,7,8,9,10};
      int days = 5;
      System.out.println(shipWithinDays(packages, days));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int[] ans = findLargestOptimal(weights);
        int start = ans[0];
        int end = ans[1];
        System.out.println(start + " " + end);
        while(start<=end){
            int mid = start+(end-start)/2;
            System.out.println(mid);
            int day = countdays(weights,mid);
            System.out.println(day);
            if(day<=days){
              end = mid-1;
            }
            else{
              start = mid+1;
            }
        }
        return start;
    }

    public static int countdays(int[]weights,int size){

        int count = 0;
        int weightSum = 0;  
        for(int i = 0;i<weights.length;i++){
            weightSum +=weights[i];
            if(weightSum<=size){
                continue;
            }else{
                count++;
                i= i-1;
                weightSum =0;
            }
        }
        if(weightSum!=0){
            count++;
        }
        return count;
    }

    public static int[] findLargestOptimal(int[] array) {
    int[] arr = new int[2];
    int max = array[0];
    int sum = 0;
    for(int i =0;i<array.length;i++){
        sum+=array[i];
      if(array[i]>max){
        max = array[i];
      }
    }
    arr[0]= max;
    arr[1] = sum;
    return arr;
}
    
}


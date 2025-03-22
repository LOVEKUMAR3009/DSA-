package training;

public class MaxSum {
  public static void main(String[] args) {
    int [] arr = {1,3,-1,-3,5,3,6,7};
    int maxSum = maxSum(arr,4);
    System.out.println(maxSum);
  }

  public static int maxSum(int[] arr,int k) {
    int maxSum = 0;
    for(int i = 0;i<k;i++){
      maxSum +=arr[i];
    }
    int j = 0;
    int sum = maxSum;
    for(int i = k;i<arr.length;i++){
      sum+=arr[i];
      sum-=arr[j];
      j++;
      maxSum = Math.max(maxSum,sum);
    }
    return maxSum;
  }
}

package knapsack.zeroone;

public class EqualSumPartition {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 4};
    int n = arr.length;
    System.out.println(canPartition(arr,n ));

  }

  public static boolean canPartition(int[] arr,int n ) {
      int sum = 0;
      for(int num:arr){
        sum+=num;
      }
      if(sum%2!=0){
        return false;
      }
      int target = sum/2;
      return TargetSum.isTargetSumPossible(arr,n,target);
  }

}

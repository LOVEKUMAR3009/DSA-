package knapsack.zeroone;

public class TargetSum {
  public static void main(String[] args) {
    int[] arr = {1, 2,4};
    int target = 7;
    int n = arr.length;
    // System.out.println(isTargetSumPossible(arr, n, target));
    System.out.println(numberOfTargetSumPossible(arr, n, target));
  }

  public static boolean isTargetSumPossible(int[]item,int n,int target){
    if(target==0){
      return true;
    }
    if(n==0){
      return false;
    }

    if(target>=item[n-1]){
      return(isTargetSumPossible(item, n-1, target-item[n-1])|| isTargetSumPossible(item, n-1, target));
    }
    else{
      return isTargetSumPossible(item, n-1, target);
    }
  }
  public static int numberOfTargetSumPossible(int[]item,int n,int target){
    if(target==0){
      return 1;
    }
    if(n==0){
      return 0;
    }

    if(target>=item[n-1]){
      return(numberOfTargetSumPossible(item, n-1, target-item[n-1])+ numberOfTargetSumPossible(item, n-1, target));
    }
    else{
      return numberOfTargetSumPossible(item, n-1, target);
    }
  }
}

package binarysearch.problems;

public class Floor {
  public static void main(String[] args) {
    int[] ar = {1,2};
    int ans = floor(ar, 2);
    System.out.println(ans);
    System.out.println(ar[ans]);
    // int result = Ceil.ceil(ar,21);
    // System.out.println(ar[result]);
  }

  public static int floor(int[]arr,int target){
    System.out.println(UpperBound.upperBound(arr, target));
    int ans = UpperBound.upperBound(arr, target) -1;
    return ans;
  }
}

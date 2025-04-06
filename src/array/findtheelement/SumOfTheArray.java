package array.findtheelement;

public class SumOfTheArray {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
  }

  public static int sum(int[]arr){
    int sum = 0;
    for(int n:arr){
      sum+=n;
    }
    return sum;
  }
}

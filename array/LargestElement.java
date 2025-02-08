package array;

public class LargestElement {
  public static int largestNumber(int[]arr){
    int largest = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (largest < arr[i]) {
            largest = arr[i];
        }
    }
    return largest;

  }
  public static int secondLargest(int[]arr){
    int largest = largestNumber(arr);
    int second = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > second && arr[i] != largest) {
            second = arr[i];
        }
    }
    return second;

  }

  public static int secondLargest2(int[]arr){
    int largest = arr[0];
        int second = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            }
            if (arr[i] < largest && arr[i] > second) {
                second = arr[i];
            }
        }
        return second;

  }


}

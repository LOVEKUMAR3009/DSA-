package array;

public class RemovDuplicate {
  public static int removeDuplicate(int[]arr){
    int j = 0;
    int key = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (key == arr[i]) {
            continue;
        } else {
            arr[j] = key;
            key = arr[i];
            j++;
        }
    }
    arr[j++] = key;
    
    return j;

  }
  public static int[] removeDuplicate2(int[]arr){
    int j=0;
    for ( int i = 1; i < arr.length; i++) {
      if(arr[i]!=arr[j]){
        j++;
        arr[j]=arr[i];
      }
    }
    return arr;
  }
  public static int removeDuplicate3(int[]arr){
    int j=0;
    for ( int i = 1; i < arr.length; i++) {
      if(arr[i]!=arr[j]){
        j++;
        arr[j]=arr[i];
      }
    }
    return j+1;
  }
}

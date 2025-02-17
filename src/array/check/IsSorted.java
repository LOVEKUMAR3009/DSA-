package array.check;

public class IsSorted {
  public static void main(String[] args) {
    int [] array = {1,2,5,3,4,6};
    boolean isSorted = isSorted(array);
    System.out.println(isSorted);
  }
 /* this fuction check the array is sorted in non descending order 
 */ 
  public static boolean isSorted(int[] array) {
    int n = array.length-1;
    boolean isSorted = true;
    for(int i=0;i<n-1;i++){
      // check is the next element is lesser or not 
      if(array[i]>array[i+1]){
        isSorted = false;
        return isSorted;
      }
    }
    return isSorted;
  }
}

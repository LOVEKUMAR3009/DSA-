package array.rotation;

import java.util.Arrays;

public class RightRotation {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    // rightRoatationbyOne(arr);
    // rightRotatedBy_D_Place2(arr, 2);
    // leftRotatedBy_D_PlaceOptimal(arr,2);
    System.out.println(Arrays.toString(arr));
  }

  public static void rightRoatationbyOne(int[]arr){
    //check the edge case
    if(arr.length ==0){
      return;
    }
    int n = arr.length;
    int lastElement = arr[n-1];
    //starting from the second last index and shift right and doing till the first element and then put the last element in the first place
    for(int i =n-2;i>=0;i--){
      arr[i+1]=arr[i];
    }
    arr[0]= lastElement;
  }
   /* 
   * right rotate the array by D place 
   * 
   * brute force rightRotatedBy_K_Place solution is rotate the array one place d times
   */

   public static void rightRotatedBy_D_Place(int[]arr,int d){
    int n = arr.length;
    d = d%n;
    for(int i =1;i<=d;i++){
      rightRoatationbyOne(arr);
    }
   }

    /* 
    * 
      different solution but still brute
      extra space is used o(n)
    */

    public static void rightRotatedBy_D_Place2(int[]arr,int d){
      int n = arr.length;
      d = d%n;
      int[] temp = new int[d];
      //copying the last d elements of the array into temp array
      for(int i =n-d;i<n;i++){
        temp[i-(n-d)] = arr[i];
      }
      //copying the rest of the element into the same array but d place right
      for(int i =n-d-1;i>=0;i--){
        arr[i+d] = arr[i];
      }

      //copying the temp array element in the original array from first place to d place
      for(int j = 0;j<d;j++){
        arr[j]= temp[j];

      }
    }

    /*
     * here we call the revere function 3 times
     * time complexity wil be o(d+n-d+n)= o(2n)
     */
    public static void leftRotatedBy_D_PlaceOptimal(int[]arr,int d){
      int n = arr.length;
      d = d%n;
      //revere the first d place
      LeftRoatation.reverseArray(arr, n-d, n-1);  //o(d/2)
      //reverse the rest of the array
      LeftRoatation.reverseArray(arr, 0, n-d-1); //o((n-d)/2) 
      //reverse the whole array
      LeftRoatation.reverseArray(arr, 0, n-1); //o(n/2)

    }

}

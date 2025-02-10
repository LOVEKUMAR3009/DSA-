package array2.rotation;

import java.util.Arrays;

import sorting.selction.Swapping;

public class LeftRoatation {
  public static void main(String[] args) {
    int [] arr = {9,1,2,3,4,5,6};


    // leftRotatedByOne(arr);
    // leftRotatedBy_D_Place(arr, 8);
    // leftRotatedBy_D_Place2(arr, 3);
    leftRotatedBy_D_PlaceOptimal(arr, 3);
    System.out.println(Arrays.toString(arr));
  }

  /*
   * this leftRotatedByOne takes the array and put the first element at the end  and shift rest of the element one place left from its original place 
   */

   /* time complexity is o(n)
      space is o(n) in algo but o(1) is auxilary space
    *solution is first pick the first and store it in the variabele and left shift rest of the element and then put the stored element at last after all iteration
    */
  public static void leftRotatedByOne(int[]arr){
    //check the edge case
    if(arr.length ==0){
      return;
    }
    int n = arr.length;
    int firstElement = arr[0];
    for(int i =1;i<n;i++){
      arr[i-1]=arr[i];
    }
    arr[n-1]= firstElement;
  } 

  



  /* 
   * left rotate the array by D place 
   * 
   * brute force leftRotatedBy_K_Place solution is rotate the array one place d times
   */

   public static void leftRotatedBy_D_Place(int[]arr,int d){
    int n = arr.length;
    d = d%n;
    for(int i =1;i<=d;i++){
      leftRotatedByOne(arr);
    }
   }

   /* 
    * 
      different solution but still brute
      extra space is used o(n)
    */

    public static void leftRotatedBy_D_Place2(int[]arr,int d){
      int n = arr.length;
      d = d%n;
      int[] temp = new int[d];
      //copying the first d elements of the array into temp array
      for(int i =0;i<d;i++){
        temp[i] = arr[i];
      }
      //copying the rest of the element into the same array but d place left
      for(int i =d;i<n;i++){
        arr[i-d] = arr[i];
      }

      //copying the temp array element in the original array from n-d place to n-1 place
      for(int j = n-d;j<n;j++){
        arr[j]= temp[j-n+d];

      }
    }



    /*
     * 
     * optimal solution is using reverse function
     * in which we first reverse first d place and then rest of the array ,and then reverse the whole array
     */

    public static void reverseArray(int []arr,int start,int end){
      while(start<=end){
        Swapping.swap(arr, start, end);
        start++;
        end--;
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
      reverseArray(arr, 0, d-1);  //o(d/2)
      //reverse the rest of the array
      reverseArray(arr, d, n-1); //o((n-d)/2) 
      //reverse the whole array
      reverseArray(arr, 0, n-1); //o(n/2)

    }

}
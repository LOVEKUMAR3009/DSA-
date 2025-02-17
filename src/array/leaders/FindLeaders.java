package array.leaders;

import java.util.ArrayDeque;
import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.Deque;
// import java.util.List;
import java.util.List;

public class FindLeaders {
  public static void main(String[] args) {
    int[] arr = {16 ,17 ,4 ,3 ,5 ,2};
    findLeadersOptimal(arr);
  }


  /*
   * brute force is pick every element and check if it is greater than all the elements on its right side 
   */

   /*
    * 
    as we know last element is always going to be leader because we know there is no one greater than that so if we keep the max of right side than we can solve this easily
    */
  public static void findLeadersOptimal(int[] arr) {
      Deque<Integer> leaders = new ArrayDeque<>();
      int n = arr.length;
      int max = Integer.MIN_VALUE; // initialize max as negative infinity for remembering the max of right
      for(int i =n-1;i>=0;i--){
        if(arr[i] > max){
          max = arr[i];
          leaders.addFirst(arr[i]);
        }
      }
      System.out.println(leaders);

      // List<Integer> ans = new ArrayList<>();
      
      
  }
}

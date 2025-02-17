package array.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrangeBySign {
  public static void main(String[] args) {
    int[] arr = { -1, 2, -3, 4, -5,-6,-3,-4,3};
    arrangeBySignBurte(arr);
    System.out.println(Arrays.toString(arr));
  }

  /*
   * when the number of signs are equals
   */
  public static int[] arrangeBySign(int[] arr) {
    int pos = 0, neg = 1;
    int n= arr.length;
    int [] ans = new int[n];
    for (int i = 0; i < arr.length; i++) {
      if(arr[i]>0){
        ans[pos]=arr[i];
        pos +=2;
      }
      else{
        ans[neg]=arr[i];
        neg +=2;
      }
    }
    return ans;
  }
        
/*
 * 
 * WHEN THE NUMBER OF SIGNS ARE NOT EQUAL
 */



 /* 
  * this algo is optimal when the number of signs are not equal
  */
 public static void arrangeBySignBurte(int[] arr) {

  List<Integer> pos = new ArrayList<>();
  List<Integer> neg = new ArrayList<>();

  // dividing the negative and positive element in the different array 
  for (int i = 0; i < arr.length; i++) {
    if(arr[i]>=0){
      pos.add(arr[i]);
    }
    else{
      neg.add(arr[i]);
    }
  }

  
  int posLength = pos.size();
  int negLength = neg.size();

  // if postives are more 
  if(posLength > negLength){

    // add 2 times the negative element in the array in the ariginal array
    for(int i = 0; i < negLength; i++){
      arr[2*i] = pos.get(i);
      arr[2*i+1] = neg.get(i);
    }
    int index = 2 *negLength;
    // add the rest of the positive
    for(int i = negLength; i < posLength; i++){
      arr[index] = pos.get(i);
      index++;
    }

  }
  // if the negative are more
  else{
    // add 2 times the positive element in the array in the ariginal array
    for(int i = 0; i < posLength; i++){
      arr[2*i] = pos.get(i);
      arr[2*i+1] = neg.get(i);
    }
    int index = 2 *posLength;
    // adding the rest of the negative element
    for(int i = posLength; i < negLength; i++){
      arr[index] = neg.get(i);
      index++;
    }

  }


    
  }
}

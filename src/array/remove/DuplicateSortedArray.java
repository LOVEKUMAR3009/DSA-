package array.remove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
// import java.util.LinkedHashSet;
import java.util.Set;
// import java.util.TreeSet;

import sorting.selction.Swapping;

public class DuplicateSortedArray {
  public static void main(String[] args) {
    int [] array = {1,1,1,2,2,3};
    // Object [] result = removeDuplicatefromArray(array);
    // System.out.println(Arrays.toString(result));

    // List<Integer> result = removeDuplicatefromArraySorted(array);
    // System.out.println(result);



    
    System.out.println(removeDuplicatefromArrayInPlace(array));
    System.out.println(Arrays.toString(array));







  }
  /* 
   * this removeDuplicatefromArray methods  can work on any array, not just on sorted array
   * and it is creating a set 
   */
  public static Object[] removeDuplicatefromArray(int []arr){
    
    int n = arr.length;
    Set <Integer> set = new HashSet<Integer>();// random order
    /*
    Set <Integer> set1 = new LinkedHashSet<Integer>();  // preserve the order of insertion
    Set <Integer> set2 = new TreeSet<Integer>();        // sort the set 
    
    */

    for(int i = 0;i<n;i++){
      if(set.contains(arr[i])){
      }
      else{
        set.add(arr[i]);
      }
    }
   

    return set.toArray();
}


/* 
 * this removeDuplicatefromArraySorted method works only on sorted array
 * and it is creating a new list and returning the list 
 */
  public static List<Integer> removeDuplicatefromArraySorted(int []arr){
  
  List<Integer> list = new ArrayList<Integer>();
  int n = arr.length;
  for(int i =0;i<n;i++){
    // previous code can also be written in this way as well 
    // if list is empty add the elemetn or if last element of llist is not the same as current element add the element
    if(list.size()== 0 || list.get(list.size()-1)!=arr[i]){
      list.add(arr[i]);
    }
  }
  return list;
  }


  /*
   * question is create a function in which we don't create any extra array or anything ,we just have to place all unique element in the 
   * begining of the array and rest of the element can be anything and return the number of unique element
   * 
   */

   public static int removeDuplicatefromArrayInPlace(int []arr){
    int n = arr.length;
    int j =0;
    for(int i =0;i<n;i++){
      if(arr[i] == arr[j]){
        continue;
      }
      else{
        j++;
        Swapping.swap(arr, j, i);
      }

    }
    return j+1;
  
  }
}

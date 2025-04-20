package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem {
  public static void main(String[] args) {
    // printNumbers(6);
    // System.out.println(sum(10, 0));

    int[]arr = {1,1,1,2,2};
    ArrayList<Integer> list = new ArrayList<>();
    System.out.println(combinationWithSumK2(5, arr, 4, list, 0));
    // System.out.println(noofSubsequencewithSumK(0,arr,list,3));
    // reverseArray(arr, 0);
    // System.out.println(Arrays.toString(arr));
    // System.out.println(fibbonaci(6));

    // System.out.println(ispallindrom("1121", 0));
  }
  public static void printName(int n){
    if(n==0){
      return;
    }
    System.out.println("Love");
    printName(n-1);

  }

  // from 1 to n
  public static void printNumbers(int n){
    if(n==0){
      return;
    }
    printNumbers(n-1);
    System.out.println(n);
  }
  // sum of first N numbers

  // parametrised way
  public static int sum(int i,int sum){
    if(i==0){
      return sum;
    }
    return sum(i-1,sum+i);
  }

  public static void reverseArray(int[]arr,int start,int end){
    if(end==start) return;
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverseArray(arr,start+1,end-1);
  }
  public static void reverseArray(int[]arr,int start ){
    int n = arr.length;
    int end = n-1-start;
    if(end==start) return;
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverseArray(arr,start+1,end-1);
  }

  public static boolean  ispallindrom(String str,int i){
    int n = str.length();
    if(i==n/2) return true;
    if(str.charAt(i)==str.charAt(n-1-i)){
      return  ispallindrom(str,i+1);
    }
    return false;
  }


  public static int fibbonaci(int n){
    if(n<=1){
      return n;
    }
    return fibbonaci(n-1)+fibbonaci(n-2);
  }


  public static void powerset(int i,int[]arr,ArrayList<Integer> temp){
    int n = arr.length;
    if(i==n){
      System.out.println(temp);
      return;
    }
    temp.add(arr[i]);
    powerset(i+1,arr,temp);
    temp.remove(temp.size()-1);
    // list.add(temp);
    powerset(i+1,arr,temp);

  }
  public static void powerset(int i,int[]arr,ArrayList<Integer> temp,int k){
    int n = arr.length;
    if(i==n){
      if(k==0){
        System.out.println(temp);
      }
      return;     
    }
    temp.add(arr[i]);
    powerset(i+1,arr,temp,k-arr[i]);
    temp.remove(temp.size()-1);
    // list.add(temp);
    powerset(i+1,arr,temp,k);
  }

  // any one sequence
  public static boolean sumofSubsequence(int i,int[]arr,ArrayList<Integer> temp,int k){
    int n = arr.length;
   
    if(i==n){
      if(k==0){
        System.out.println(temp);
        return true;
      }
      return false;
    }
    temp.add(arr[i]);
    if(sumofSubsequence(i+1,arr,temp,k-arr[i])){
      return true;
    }
    
    temp.remove(temp.size()-1);
    // list.add(temp);
    if(sumofSubsequence(i+1,arr,temp,k)) return true;
    return false;
  }
  public static int noofSubsequencewithSumK(int i,int[]arr,ArrayList<Integer> temp,int k){
    int count =0;
    int n = arr.length;
    if(i==n){
      if(k==0){
        System.out.println(temp);
        return 1;
      }
      return 0;
    }
    temp.add(arr[i]);
    count+=noofSubsequencewithSumK(i+1,arr,temp,k-arr[i]);
    
    temp.remove(temp.size()-1);
    // list.add(temp);
    count+=noofSubsequencewithSumK(i+1,arr,temp,k);
    return count;
  }

  public static List<List<Integer>>  combinationWithSumK(int n,int[]arr,int k,List<Integer>temp,int sum){
    List<List<Integer>> ans = new ArrayList<>();
    if(sum>k) return ans;
    if(k==sum){
      ans.add(new ArrayList<>(temp));
      return ans;
    }
    if(n==0){
      return ans;
    }
    temp.add(arr[n-1]);
    ans.addAll(combinationWithSumK(n, arr, k, temp, sum+arr[n-1]));
    temp.remove(temp.size()-1);
    ans.addAll(combinationWithSumK(n-1, arr, k, temp, sum));
    return ans;   
  }
  public static Set<List<Integer>>  combinationWithSumK2(int n,int[]arr,int k,List<Integer>temp,int sum){
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> unique = new HashSet<>();
    if(sum>k) return unique;
    if(k==sum){
      temp.sort(null);
      unique.add(new ArrayList<>(temp));
      return unique;
    }
    if(n==0){
      return unique;
    }
    temp.add(arr[n-1]);
    unique.addAll(combinationWithSumK2(n-1, arr, k, temp, sum+arr[n-1]));
    temp.remove(temp.size()-1);
    unique.addAll(combinationWithSumK2(n-1, arr, k, temp, sum));
    return unique;   
  }


  
}




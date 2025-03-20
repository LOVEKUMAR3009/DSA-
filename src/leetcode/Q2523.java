package leetcode;

import java.util.*;
public class Q2523 {
    public static int[] closestPrimes(int left, int right) {
        
        int arr[] ={-1,-1};
        int j = -1;
        int distance = right-left+2;
        for(int i =left;i<=right;i++){
            boolean result = isPrime(i);
            if(result == false ){
                continue;
            }
            else{
                if(j ==-1){
                  j= i;
                  continue;
                }
                int temp = i-j;
                if(distance > temp){
                  distance = temp;
                    arr[0] = j;
                    arr[1] = i;
                    j = i;
                }
                else{
                    j = i;
                }
                


               
            }
        }
        return arr;

    }

      public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    } 


    public static void main(String[] args) {
      int[]  result = closestPrimes(5,17);
      System.out.println(Arrays.toString(result));
      // System.out.println(result);
    }

}

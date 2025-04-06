package training;

import java.util.Arrays;

public class Product {
  public static void main(String[] args) {
    int[] arr = {-1,1,0,-3,3};
    System.out.println(Arrays.toString(product(arr, 3)));
  }

  public static int[] product(int[] arr){
    int product = 1;
    int count = 0;
    int index = -1;
    for(int i = 0;i<arr.length;i++){
      if(arr[i] == 0 && count == 0){
        count++;
        index = i;
        continue;
      }
      product *= arr[i];
    }
    return new int[]{product,index};
  }
  public static int[] product(int[] arr,int k){
    int[] result = new int[arr.length];
    int n = arr.length;
    int currentProduct = 1;
    for(int i = 0;i<arr.length;i++){
        int j = i+1;
        int count = 0;
        int product = 1;
        while(count<k){
          j = j%n;
          product = product*arr[j];
          count++;
          j++;

        }
        result[i] = product;
    }
    return result;
  }
}

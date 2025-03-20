package array.findtheelement;

import java.util.Arrays;

public class FindTheMissingElement {
  public static void main(String[] args) {
    int[] arr= {1,2,2,3};  
    System.out.println(Arrays.toString(findmissingNumber3(arr)));
  }

  // 

  public static int[] findmissingNumber(int[]arr){
    int [] ans = new int[2];
    for(int i =1;i<=arr.length;i++){
      int temp = i;
      int count =0;
      for(int j =0;j<arr.length;j++){
        if(arr[j]==temp){
          count++;
        }
      }
      if(count==2){
        ans[0]=temp;
      }
      if(count==0){
        ans[1] = temp;
      }

    }
    return ans;
  }


  public static int[] findmissingNumber2(int[]arr){
    int [] ans = new int[2];
    int n = arr.length;
    int [] hash = new int[n+1];
    
    for(int i:arr){
      hash[i]++;
    }
    for(int i =1;i<n+1;i++){
      if(hash[i]==0){
        ans[1] = i;
      }
      if(hash[i]==2){
        ans[0] = i;
      }
    }
    return ans;
  }



  /*
   * mathmatics solution is
   */

  public static int[] findmissingNumber3(int[]arr){
    int[] ans = new int[2];
    int n= arr.length;
    long sN = n*(n+1)/2;
    long s2N = n*(n+1)*(2*n+1)/6;
    long s =0;
    long s2 = 0;
    for(int i :arr){
      s+=i;
      s2+=i*i;
    }
    long diff = s-sN; //x-y 
    long diffsq = s2-s2N; //x2-y2
    long sum = diffsq/diff; // x+y
    int x = (int)(sum+diff)/2;
    int y = (int)(sum-diff)/2;
    ans[0] = x;
    ans[1] = y;
    return ans;

    
  }


  
}


package array.subarray1;

public class MaxProduct {
  //brute force approach is to generate all the possible sub array  and check wheather it is max

  public static void main(String[] args) {
    int[] arr = {2,-3,4,3,-1,-2,5,-4,3};

    /*
     * {}
     */
    int max = findMaxProduct1(arr);
    System.out.println(max);
      }
    
      public static int findMaxProduct(int[] arr) {
        int max = 0;
        for(int i = 0;i<arr.length;i++){
          for(int j = i;j<arr.length;j++){
            int product = 1;
            for(int k = i;k<=j;k++){
              product *= arr[k];
            }
            
            max = Math.max(max, product);
          }
        }
        return max;
      }
      public static int findMaxProduct1(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for(int i = 0;i<n;i++){
          if(prefix ==0) prefix =1;
          if(suffix ==0) suffix = 1;
          prefix *=arr[i];
          suffix *=arr[n-i-1];
          max = Math.max(max, Math.max(prefix, suffix));
         
        }
        return max;
      }
}

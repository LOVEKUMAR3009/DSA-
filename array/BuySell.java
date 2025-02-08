package array;

public class BuySell {
  //DP Stocks
  // space optimization is very important
  //brute force 
  public static void main(String[] args) {
    int [] arr = {7,1,5,15,1,4};
    System.out.println(buySell2(arr));
    
  }
  //own
  public static int butSell(int[]arr){
    int max=0; int buydate =0;
    int selldate =0;
    for(int i=0;i<arr.length;i++){
      for(int j=i+1;j<arr.length;j++){
        int diff = arr[j]-arr[i];
        if(max<diff){
          buydate =i;
          selldate=j;
          max=diff;
        }
      }
    }
    System.out.println("buy "+buydate+" sell"+selldate);
    return max;
  }

  public static int buySell2(int[]arr){
    // we hava to track the minimum in left from the particular point in the array
    int min = arr[0];
    int profit = 0;
    for(int i=1;i<arr.length;i++){
      int cost = arr[i]-min;
      profit = Math.max(profit, cost);
      min = Math.min(min,arr[i]);
    }
    return profit;
  }
}

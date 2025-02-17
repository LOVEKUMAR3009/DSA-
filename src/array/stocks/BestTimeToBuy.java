package array.stocks;

public class BestTimeToBuy {
  public static void main(String[] args) {
    int [] arr = {7,1,5,3,6,4};
    System.out.println(buyStock(arr));

  }

  /*
   * we have to keep in mind which element is smallest in left of the current element 
   */
  public static int buyStock(int[] arr){
    int n = arr.length;
    // assume that first element is the smallest
    int min =arr[0];
    int profit = 0;
    for(int i =1;i<n;i++){
      // find the current profit if we sell at current index
      int currentProfit = arr[i] -min;
      // check if that is the maximum profit we got earlier
      profit = Math.max(profit,currentProfit);
      // update the minvalue in the left of the current pointer
      min = Math.min(min,arr[i]);

    }
    return profit;
   
  }


}

package knapsack.zeroone;

public class MaxProfit {
  public static void main(String[] args) {
    int[]item = {4,2,3,7};
    int[]weight = {6,7,9,12};
    int capacity = 15;
    int n = item.length;
    System.out.println(maxProfitBounded(item, weight, n, capacity));
  }

  /*
   * bounded when the picked element cannot be repeadted
   */
  public static int maxProfitBounded(int[]item,int[] cost,int n,int capacity){
    if(n==0 || capacity==0){
      return 0;
    }
    if(capacity>=item[n-1]){
                        // pick                                               // not pick
      return Math.max(cost[n-1]+maxProfitBounded(item,cost,n-1,capacity-item[n-1]),maxProfitBounded(item,cost,n-1,capacity));
    }else{
      return maxProfitBounded(item,cost,n-1,capacity);
    }
  }


  /*
   * unbounded when the picked element can be repeated again
   */
  public static int maxProfitUnBounded(int[]item,int[] cost,int n,int capacity){
    if(n==0 || capacity==0){
      return 0;
    }
    if(capacity>=item[n-1]){
                        // pick                                               // not pick
      return Math.max(cost[n-1]+maxProfitUnBounded(item,cost,n,capacity-item[n-1]),maxProfitUnBounded(item,cost,n-1,capacity));
    }else{
      return maxProfitUnBounded(item,cost,n-1,capacity);
    }
  }
  

}

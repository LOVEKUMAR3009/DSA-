package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rearrange {
  public static void main(String[] args) {
    int[] arr = {-3,1,2,-5,-7,-9,3,8,9,9};
    // System.out.println(Arrays.toString(rearrage(arr)));
    System.out.println(Arrays.toString(rearrage2(arr)));
    
  }
  public static int[] rearrage(int[]arr){
    int[] ans = new int[arr.length];
    int positive=0;
    int negative=1;
    for(int i=0;i<arr.length;i++){
      if(arr[i]<0){
        ans[negative]=arr[i];
        negative= negative+2;
      }
      else{
        ans[positive]=arr[i];
        positive=positive+2;
      }
    }
    return ans;
  }


  public static int[] rearrage2(int[]arr){
    List<Integer> positive = new ArrayList<Integer>();
    List<Integer> negative = new ArrayList<Integer>();

    //push in the two arrays
    for(int i=0;i<arr.length;i++){
      if(arr[i]<0){
        negative.add(arr[i]);
      }
      else{
        positive.add(arr[i]);
      }
    }
    int commonLength = Math.min(positive.size(),negative.size());
    //pushing atlernate numbers in the ans array
    for(int j=0;j<commonLength;j++){
      arr[j*2]=positive.get(j);
      arr[j*2+1]=negative.get(j);
    }
    boolean isPostivebig = positive.size()>negative.size();
  // pushing the reemiang numbers
    if(isPostivebig){
      int start= commonLength*2;
      for(int i = commonLength;i<positive.size();i++){
        arr[start]=positive.get(i);
        start++;
      }
    }
    else{
      int start= commonLength*2;
      for(int i = commonLength;i<negative.size();i++){
        arr[start]=negative.get(i);
        start++;
      }
    }
    return arr;
  }

}

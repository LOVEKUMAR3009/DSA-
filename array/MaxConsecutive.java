package array;

public class MaxConsecutive {
  public static int maxConsecutive(int []arr){
    int max =0;
    int ans =0;
    for(int i=0;i<arr.length;i++){
      if(arr[i]==1){
        ans++;
      }
      else{
        max=ans;
        ans=0;
      }
    }
    return max;
  }
}

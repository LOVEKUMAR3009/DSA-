package leetcode;
public class Q2529 {

  public static void main(String[] args) {
    int[] arr = {-3,-2,-1,0,0,1,2};
    System.out.println(maximumCount(arr));
  }
  public static int maximumCount(int[] nums) {
    int n = nums.length;
    int countnegative = 0;
    int countpositive = 0;
    for(int i = 0;i<n;i++){
        if(nums[i]<0){
            countnegative++;
        }
        else if(nums[i]==0){
            continue;
        }
        else{
            countpositive = nums.length-i;
            break;
        }
    }
    return Math.max(countnegative, countpositive);

}
}
